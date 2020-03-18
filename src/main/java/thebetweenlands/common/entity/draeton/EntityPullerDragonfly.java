package thebetweenlands.common.entity.draeton;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import thebetweenlands.common.entity.draeton.EntityWeedwoodDraeton.IPullerEntity;
import thebetweenlands.common.entity.draeton.EntityWeedwoodDraeton.Puller;
import thebetweenlands.common.entity.mobs.EntityDragonFly;

public class EntityPullerDragonfly extends EntityDragonFly implements IPullerEntity, IEntityAdditionalSpawnData {
	private int carriageId;
	private int pullerId;

	private Puller puller;

	public EntityPullerDragonfly(World world) {
		super(world);
	}

	public EntityPullerDragonfly(World world, EntityWeedwoodDraeton carriage, Puller puller) {
		super(world);
		this.setPuller(carriage, puller);
	}

	@Override
	public void setPuller(EntityWeedwoodDraeton carriage, Puller puller) {
		this.puller = puller;
		this.pullerId = puller.id;
		this.carriageId = carriage.getEntityId();
	}

	@Override
	public float getPull(float pull) {
		return pull;
	}

	@Override
	public float getCarriageDrag(float drag) {
		return drag;
	}

	@Override
	public float getDrag(float drag) {
		return drag;
	}

	@Override
	public void releaseEntity() {
		if(!this.world.isRemote) {
			EntityDragonFly entity = new EntityDragonFly(this.world);
			entity.readFromNBT(this.writeToNBT(new NBTTagCompound()));
			entity.setNoAI(false);
			entity.setUniqueId(UUID.randomUUID());
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			this.world.spawnEntity(entity);
			
			this.setDead();
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if(source == DamageSource.IN_WALL) {
			return false;
		}
		return super.attackEntityFrom(source, amount);
	}

	@Override
	public boolean writeToNBTOptional(NBTTagCompound compound) {
		//Entity is saved and handled by carriage
		return false;
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	@Override
	public boolean isAIDisabled() {
		return true;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if(this.puller == null || !this.puller.isActive) {
			if(!this.world.isRemote) {
				//Don't remove immediately if entity is already dying
				if(this.isEntityAlive()) {
					this.setDead();
				}
			} else {
				Entity entity = this.world.getEntityByID(this.carriageId);
				if(entity instanceof EntityWeedwoodDraeton) {
					Puller puller = ((EntityWeedwoodDraeton) entity).getPullerById(this.pullerId);
					if(puller != null) {
						this.puller = puller;
						puller.setEntity(this);
					}
				}
			}
		} else {
			this.setPositionAndRotation(this.puller.x, this.puller.y, this.puller.z, 0, 0);
			this.rotationYaw = this.rotationYawHead = this.renderYawOffset = (float)Math.toDegrees(Math.atan2(this.puller.motionZ, this.puller.motionX)) - 90;
			this.rotationPitch = (float)Math.toDegrees(-Math.atan2(this.puller.motionY, Math.sqrt(this.puller.motionX * this.puller.motionX + this.puller.motionZ * this.puller.motionZ)));
		}
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		buffer.writeInt(this.carriageId);
		buffer.writeInt(this.pullerId);
	}

	@Override
	public void readSpawnData(ByteBuf buffer) {
		this.carriageId = buffer.readInt();
		this.pullerId = buffer.readInt();
	}
}