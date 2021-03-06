package thebetweenlands.client.render.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/**
 * BLDraetonBalloon - TripleHeadedSheep
 * Created using Tabula 7.0.1
 */
public class ModelDraetonBalloon extends ModelBase {
    public ModelRenderer balloon_mainrotation;
    public ModelRenderer balloon_main1;
    public ModelRenderer balloon_main2;
    public ModelRenderer heatvent1;
    public ModelRenderer bonemidl;
    public ModelRenderer bonemidr;
    public ModelRenderer base_main;
    public ModelRenderer balloon_main3;
    public ModelRenderer balloon_side1r;
    public ModelRenderer balloon_side1l;
    public ModelRenderer supportbeam_back1m;
    public ModelRenderer bone1;
    public ModelRenderer balloon_side3r;
    public ModelRenderer balloon_side3l;
    public ModelRenderer balloon_back;
    public ModelRenderer supportbeam_back2m;
    public ModelRenderer bone3;
    public ModelRenderer skin3r;
    public ModelRenderer skin3l;
    public ModelRenderer balloon_back_r;
    public ModelRenderer balloon_back_l;
    public ModelRenderer supportbeam_back2r;
    public ModelRenderer supportbeam_back2l;
    public ModelRenderer ropeconnection_b2r;
    public ModelRenderer ropeconnection_b2l;
    public ModelRenderer skin1r;
    public ModelRenderer skin1l;
    public ModelRenderer supportbeam_back1r;
    public ModelRenderer supportbeam_back1l;
    public ModelRenderer ropeconnection_b1r;
    public ModelRenderer ropeconnection_b1l;
    public ModelRenderer balloon_main4;
    public ModelRenderer balloon_side2r;
    public ModelRenderer balloon_side2l;
    public ModelRenderer supportbeam_front1m;
    public ModelRenderer bone2;
    public ModelRenderer balloon_side4r;
    public ModelRenderer balloon_side4l;
    public ModelRenderer baloon_front;
    public ModelRenderer supportbeam_front2m;
    public ModelRenderer bone4;
    public ModelRenderer skin4r;
    public ModelRenderer skin4l;
    public ModelRenderer balloon_front_r;
    public ModelRenderer balloon_front_l;
    public ModelRenderer supportbeam_front2r;
    public ModelRenderer supportbeam_front2l;
    public ModelRenderer ropeconnection_f2r;
    public ModelRenderer ropeconnection_f2l;
    public ModelRenderer skin2r;
    public ModelRenderer skin2l;
    public ModelRenderer supportbeam_front1r;
    public ModelRenderer supportbeam_front1l;
    public ModelRenderer ropeconnection_f1r;
    public ModelRenderer ropeconnection_f1l;
    public ModelRenderer heatvent2;
    public ModelRenderer base_edge1a;
    public ModelRenderer base_edge2a;
    public ModelRenderer vialholder_main;
    public ModelRenderer burner_main;
    public ModelRenderer rope_back_left1;
    public ModelRenderer rope_back_right1;
    public ModelRenderer rope_front_left1;
    public ModelRenderer rope_front_right1;
    public ModelRenderer base_edge1b;
    public ModelRenderer base_edge2b;
    public ModelRenderer vial_base;
    public ModelRenderer vialholder1;
    public ModelRenderer vialholder2;
    public ModelRenderer vial_bottom;
    public ModelRenderer vial_top;
    public ModelRenderer burner_vialconnection1;
    public ModelRenderer burner_top;
    public ModelRenderer burner_vialconnection2;

    public ModelDraetonBalloon() {
        this.textureWidth = 256;
        this.textureHeight = 265;
        this.supportbeam_front2r = new ModelRenderer(this, 0, 8);
        this.supportbeam_front2r.setRotationPoint(-12.0F, 0.0F, 0.0F);
        this.supportbeam_front2r.addBox(-7.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(supportbeam_front2r, 0.0F, 0.0F, -0.22759093446006054F);
        this.skin3r = new ModelRenderer(this, 82, 128);
        this.skin3r.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.skin3r.addBox(-0.01F, 0.0F, 0.0F, 0, 20, 12, 0.0F);
        this.setRotateAngle(skin3r, 0.0F, 0.0F, 0.091106186954104F);
        this.ropeconnection_f1r = new ModelRenderer(this, 84, 9);
        this.ropeconnection_f1r.setRotationPoint(-5.0F, 1.0F, 0.0F);
        this.ropeconnection_f1r.addBox(-1.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.vial_bottom = new ModelRenderer(this, 0, 207);
        this.vial_bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.vial_bottom.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.balloon_side3l = new ModelRenderer(this, 44, 36);
        this.balloon_side3l.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.balloon_side3l.addBox(0.0F, 0.0F, 0.0F, 10, 16, 12, 0.0F);
        this.setRotateAngle(balloon_side3l, 0.0F, 0.0F, 0.136659280431156F);
        this.rope_front_left1 = new ModelRenderer(this, 48, 203);
        this.rope_front_left1.setRotationPoint(3.0F, 0.0F, -4.0F);
        this.rope_front_left1.addBox(0.0F, -16.0F, -1.0F, 1, 16, 1, 0.0F);
        this.setRotateAngle(rope_front_left1, 1.2292353921796064F, -1.0471975511965976F, 0.0F);
        this.base_main = new ModelRenderer(this, 0, 190);
        this.base_main.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.base_main.addBox(-4.0F, 0.0F, -5.0F, 8, 2, 10, 0.0F);
        this.supportbeam_front2l = new ModelRenderer(this, 232, 8);
        this.supportbeam_front2l.setRotationPoint(12.0F, 0.0F, 0.0F);
        this.supportbeam_front2l.addBox(0.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(supportbeam_front2l, 0.0F, 0.0F, 0.22759093446006054F);
        this.burner_vialconnection2 = new ModelRenderer(this, 17, 220);
        this.burner_vialconnection2.setRotationPoint(3.0F, 0.0F, -1.0F);
        this.burner_vialconnection2.addBox(0.0F, 0.01F, 0.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(burner_vialconnection2, 0.0F, -0.27314402793711257F, 0.0F);
        this.balloon_main4 = new ModelRenderer(this, 0, 64);
        this.balloon_main4.setRotationPoint(0.0F, 0.0F, -20.0F);
        this.balloon_main4.addBox(-9.0F, 0.0F, -12.0F, 18, 16, 12, 0.0F);
        this.setRotateAngle(balloon_main4, 0.091106186954104F, 0.0F, 0.0F);
        this.supportbeam_back2r = new ModelRenderer(this, 0, 0);
        this.supportbeam_back2r.setRotationPoint(-12.0F, 0.0F, 0.0F);
        this.supportbeam_back2r.addBox(-7.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(supportbeam_back2r, 0.0F, 0.0F, -0.22759093446006054F);
        this.ropeconnection_b2r = new ModelRenderer(this, 79, 0);
        this.ropeconnection_b2r.setRotationPoint(-5.0F, 1.0F, 0.0F);
        this.ropeconnection_b2r.addBox(-1.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.bone1 = new ModelRenderer(this, 0, 122);
        this.bone1.setRotationPoint(0.0F, 0.0F, 14.0F);
        this.bone1.addBox(-3.0F, -1.0F, 0.0F, 6, 1, 3, 0.0F);
        this.setRotateAngle(bone1, -0.045553093477052F, 0.0F, 0.0F);
        this.skin1l = new ModelRenderer(this, 0, 149);
        this.skin1l.setRotationPoint(10.0F, 0.0F, 0.0F);
        this.skin1l.addBox(0.0F, 0.0F, 0.0F, 0, 20, 20, 0.0F);
        this.setRotateAngle(skin1l, 0.0F, 0.0F, -0.091106186954104F);
        this.rope_back_right1 = new ModelRenderer(this, 43, 203);
        this.rope_back_right1.setRotationPoint(-3.0F, 0.0F, 4.0F);
        this.rope_back_right1.addBox(-1.0F, -16.0F, 0.0F, 1, 16, 1, 0.0F);
        this.setRotateAngle(rope_back_right1, -1.2292353921796064F, -1.0471975511965976F, 0.0F);
        this.supportbeam_front1m = new ModelRenderer(this, 160, 68);
        this.supportbeam_front1m.setRotationPoint(0.0F, 17.0F, -12.0F);
        this.supportbeam_front1m.addBox(-12.0F, 0.0F, -1.0F, 24, 2, 2, 0.0F);
        this.skin2r = new ModelRenderer(this, 41, 128);
        this.skin2r.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.skin2r.addBox(-0.01F, 0.0F, -20.0F, 0, 20, 20, 0.0F);
        this.setRotateAngle(skin2r, 0.0F, 0.0F, 0.091106186954104F);
        this.skin2l = new ModelRenderer(this, 41, 149);
        this.skin2l.setRotationPoint(10.0F, 0.0F, 0.0F);
        this.skin2l.addBox(0.01F, 0.0F, -20.0F, 0, 20, 20, 0.0F);
        this.setRotateAngle(skin2l, 0.0F, 0.0F, -0.091106186954104F);
        this.vialholder1 = new ModelRenderer(this, 79, 196);
        this.vialholder1.setRotationPoint(1.0F, 0.0F, 1.0F);
        this.vialholder1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.supportbeam_back2m = new ModelRenderer(this, 200, 4);
        this.supportbeam_back2m.setRotationPoint(0.0F, 17.0F, 7.0F);
        this.supportbeam_back2m.addBox(-12.0F, 0.0F, -1.0F, 24, 2, 2, 0.0F);
        this.baloon_front = new ModelRenderer(this, 0, 92);
        this.baloon_front.setRotationPoint(0.0F, 0.0F, -12.0F);
        this.baloon_front.addBox(-9.0F, 0.0F, -8.015F, 18, 16, 8, 0.0F);
        this.setRotateAngle(baloon_front, 0.18203784098300857F, 0.0F, 0.0F);
        this.supportbeam_back2l = new ModelRenderer(this, 132, 0);
        this.supportbeam_back2l.setRotationPoint(12.0F, 0.0F, 0.0F);
        this.supportbeam_back2l.addBox(0.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(supportbeam_back2l, 0.0F, 0.0F, 0.22759093446006054F);
        this.bonemidr = new ModelRenderer(this, 34, 128);
        this.bonemidr.setRotationPoint(-4.0F, -16.0F, 0.0F);
        this.bonemidr.addBox(-2.0F, -1.0F, -2.0F, 2, 1, 4, 0.0F);
        this.base_edge1a = new ModelRenderer(this, 37, 190);
        this.base_edge1a.setRotationPoint(0.0F, 2.0F, 5.0F);
        this.base_edge1a.addBox(-4.01F, -2.0F, 0.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(base_edge1a, 0.27314402793711257F, 0.0F, 0.0F);
        this.balloon_main1 = new ModelRenderer(this, 0, 0);
        this.balloon_main1.setRotationPoint(0.0F, -16.0F, 0.0F);
        this.balloon_main1.addBox(-9.0F, 0.0F, 0.0F, 18, 16, 20, 0.0F);
        this.setRotateAngle(balloon_main1, -0.045553093477052F, 0.0F, 0.0F);
        this.supportbeam_back1m = new ModelRenderer(this, 200, 0);
        this.supportbeam_back1m.setRotationPoint(0.0F, 17.0F, 12.0F);
        this.supportbeam_back1m.addBox(-12.0F, 0.0F, -1.0F, 24, 2, 2, 0.0F);
        this.ropeconnection_b2l = new ModelRenderer(this, 150, 0);
        this.ropeconnection_b2l.setRotationPoint(5.0F, 1.0F, 0.0F);
        this.ropeconnection_b2l.addBox(-1.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.rope_front_right1 = new ModelRenderer(this, 53, 203);
        this.rope_front_right1.setRotationPoint(-3.0F, 0.0F, -4.0F);
        this.rope_front_right1.addBox(-1.0F, -16.0F, -1.0F, 1, 16, 1, 0.0F);
        this.setRotateAngle(rope_front_right1, 1.2292353921796064F, 1.0471975511965976F, 0.0F);
        this.burner_top = new ModelRenderer(this, 17, 225);
        this.burner_top.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.burner_top.addBox(-2.0F, -2.0F, -2.0F, 4, 2, 4, 0.0F);
        this.bone4 = new ModelRenderer(this, 19, 127);
        this.bone4.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.bone4.addBox(-2.0F, -1.0F, -3.0F, 4, 1, 3, 0.0F);
        this.setRotateAngle(bone4, 0.045553093477052F, 0.0F, 0.0F);
        this.burner_main = new ModelRenderer(this, 17, 203);
        this.burner_main.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.burner_main.addBox(-2.0F, -5.0F, -3.0F, 4, 5, 6, 0.0F);
        this.vial_top = new ModelRenderer(this, 0, 216);
        this.vial_top.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.vial_top.addBox(-1.5F, -1.0F, -1.5F, 3, 1, 3, 0.0F);
        this.supportbeam_front2m = new ModelRenderer(this, 160, 72);
        this.supportbeam_front2m.setRotationPoint(0.0F, 17.0F, -7.0F);
        this.supportbeam_front2m.addBox(-12.0F, 0.0F, -1.0F, 24, 2, 2, 0.0F);
        this.balloon_front_r = new ModelRenderer(this, 212, 96);
        this.balloon_front_r.setRotationPoint(-9.0F, 0.0F, 0.0F);
        this.balloon_front_r.addBox(-4.0F, 0.0F, -8.0F, 4, 16, 8, 0.0F);
        this.setRotateAngle(balloon_front_r, 0.0F, 0.0F, -0.136659280431156F);
        this.skin1r = new ModelRenderer(this, 0, 128);
        this.skin1r.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.skin1r.addBox(0.0F, 0.0F, 0.0F, 0, 20, 20, 0.0F);
        this.setRotateAngle(skin1r, 0.0F, 0.0F, 0.091106186954104F);
        this.balloon_back_r = new ModelRenderer(this, 88, 36);
        this.balloon_back_r.setRotationPoint(-9.0F, 0.0F, 0.0F);
        this.balloon_back_r.addBox(-4.0F, 0.0F, 0.0F, 4, 16, 8, 0.0F);
        this.setRotateAngle(balloon_back_r, 0.0F, 0.0F, -0.136659280431156F);
        this.balloon_front_l = new ModelRenderer(this, 52, 100);
        this.balloon_front_l.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.balloon_front_l.addBox(0.0F, 0.0F, -8.0F, 4, 16, 8, 0.0F);
        this.setRotateAngle(balloon_front_l, 0.0F, 0.0F, 0.136659280431156F);
        this.balloon_main3 = new ModelRenderer(this, 152, 0);
        this.balloon_main3.setRotationPoint(0.0F, 0.0F, 20.0F);
        this.balloon_main3.addBox(-9.0F, 0.0F, 0.0F, 18, 16, 12, 0.0F);
        this.setRotateAngle(balloon_main3, -0.091106186954104F, 0.0F, 0.0F);
        this.heatvent1 = new ModelRenderer(this, 56, 0);
        this.heatvent1.setRotationPoint(0.0F, -15.5F, -4.0F);
        this.heatvent1.addBox(-4.0F, -2.0F, 0.0F, 8, 2, 7, 0.0F);
        this.vial_base = new ModelRenderer(this, 0, 203);
        this.vial_base.setRotationPoint(2.5F, 1.0F, 0.0F);
        this.vial_base.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(vial_base, 0.0F, 0.136659280431156F, 0.0F);
        this.vialholder2 = new ModelRenderer(this, 79, 199);
        this.vialholder2.setRotationPoint(1.0F, 0.0F, -1.0F);
        this.vialholder2.addBox(0.0F, 0.0F, -1.0F, 3, 1, 1, 0.0F);
        this.balloon_side3r = new ModelRenderer(this, 0, 36);
        this.balloon_side3r.setRotationPoint(-9.0F, 0.0F, 0.0F);
        this.balloon_side3r.addBox(-10.0F, 0.0F, 0.0F, 10, 16, 12, 0.0F);
        this.setRotateAngle(balloon_side3r, 0.0F, 0.0F, -0.136659280431156F);
        this.skin3l = new ModelRenderer(this, 82, 149);
        this.skin3l.setRotationPoint(10.0F, 0.0F, 0.0F);
        this.skin3l.addBox(0.01F, 0.0F, 0.0F, 0, 20, 12, 0.0F);
        this.setRotateAngle(skin3l, 0.0F, 0.0F, -0.091106186954104F);
        this.base_edge1b = new ModelRenderer(this, 37, 195);
        this.base_edge1b.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.base_edge1b.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 1, 0.0F);
        this.vialholder_main = new ModelRenderer(this, 79, 190);
        this.vialholder_main.setRotationPoint(4.0F, 0.0F, -1.5F);
        this.vialholder_main.addBox(0.0F, 0.0F, -2.0F, 1, 1, 4, 0.0F);
        this.burner_vialconnection1 = new ModelRenderer(this, 17, 215);
        this.burner_vialconnection1.setRotationPoint(2.0F, -3.0F, -2.0F);
        this.burner_vialconnection1.addBox(0.0F, 0.0F, -1.0F, 3, 2, 2, 0.0F);
        this.balloon_mainrotation = new ModelRenderer(this, 0, 0);
        this.balloon_mainrotation.setRotationPoint(0.0F, -22.0F, 0.0F);
        this.balloon_mainrotation.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.balloon_side2l = new ModelRenderer(this, 120, 64);
        this.balloon_side2l.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.balloon_side2l.addBox(0.0F, 0.0F, -20.0F, 10, 16, 20, 0.0F);
        this.setRotateAngle(balloon_side2l, 0.0F, 0.0F, 0.136659280431156F);
        this.balloon_side4l = new ModelRenderer(this, 168, 88);
        this.balloon_side4l.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.balloon_side4l.addBox(0.0F, 0.0F, -12.0F, 10, 16, 12, 0.0F);
        this.setRotateAngle(balloon_side4l, 0.0F, 0.0F, 0.136659280431156F);
        this.balloon_back = new ModelRenderer(this, 192, 44);
        this.balloon_back.setRotationPoint(0.0F, 0.0F, 12.0F);
        this.balloon_back.addBox(-9.0F, 0.0F, 0.02F, 18, 16, 8, 0.0F);
        this.setRotateAngle(balloon_back, -0.18203784098300857F, 0.0F, 0.0F);
        this.ropeconnection_b1l = new ModelRenderer(this, 147, 6);
        this.ropeconnection_b1l.setRotationPoint(5.0F, 1.0F, 0.0F);
        this.ropeconnection_b1l.addBox(-1.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.base_edge2a = new ModelRenderer(this, 58, 190);
        this.base_edge2a.setRotationPoint(0.0F, 2.0F, -5.0F);
        this.base_edge2a.addBox(-4.01F, -2.0F, -2.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(base_edge2a, -0.31869712141416456F, 0.0F, 0.0F);
        this.balloon_side1l = new ModelRenderer(this, 132, 28);
        this.balloon_side1l.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.balloon_side1l.addBox(0.0F, 0.0F, 0.0F, 10, 16, 20, 0.0F);
        this.setRotateAngle(balloon_side1l, 0.0F, 0.0F, 0.136659280431156F);
        this.heatvent2 = new ModelRenderer(this, 232, 12);
        this.heatvent2.setRotationPoint(0.0F, -2.0F, 7.0F);
        this.heatvent2.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 2, 0.0F);
        this.setRotateAngle(heatvent2, -0.091106186954104F, 0.0F, 0.0F);
        this.skin4l = new ModelRenderer(this, 107, 149);
        this.skin4l.setRotationPoint(10.0F, 0.0F, 0.0F);
        this.skin4l.addBox(0.0F, 0.0F, -12.0F, 0, 20, 12, 0.0F);
        this.setRotateAngle(skin4l, 0.0F, 0.0F, -0.091106186954104F);
        this.ropeconnection_f2l = new ModelRenderer(this, 56, 9);
        this.ropeconnection_f2l.setRotationPoint(5.0F, 1.0F, 0.0F);
        this.ropeconnection_f2l.addBox(-1.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.supportbeam_front1r = new ModelRenderer(this, 66, 9);
        this.supportbeam_front1r.setRotationPoint(-12.0F, 0.0F, 0.0F);
        this.supportbeam_front1r.addBox(-7.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(supportbeam_front1r, 0.0F, 0.0F, -0.22759093446006054F);
        this.skin4r = new ModelRenderer(this, 107, 128);
        this.skin4r.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.skin4r.addBox(0.0F, 0.0F, -12.0F, 0, 20, 12, 0.0F);
        this.setRotateAngle(skin4r, 0.0F, 0.0F, 0.091106186954104F);
        this.balloon_back_l = new ModelRenderer(this, 104, 52);
        this.balloon_back_l.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.balloon_back_l.addBox(0.0F, 0.0F, 0.0F, 4, 16, 8, 0.0F);
        this.setRotateAngle(balloon_back_l, 0.0F, 0.0F, 0.136659280431156F);
        this.supportbeam_front1l = new ModelRenderer(this, 0, 12);
        this.supportbeam_front1l.setRotationPoint(12.0F, 0.0F, 0.0F);
        this.supportbeam_front1l.addBox(0.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(supportbeam_front1l, 0.0F, 0.0F, 0.22759093446006054F);
        this.balloon_side2r = new ModelRenderer(this, 60, 64);
        this.balloon_side2r.setRotationPoint(-9.0F, 0.0F, 0.0F);
        this.balloon_side2r.addBox(-10.0F, 0.0F, -20.0F, 10, 16, 20, 0.0F);
        this.setRotateAngle(balloon_side2r, 0.0F, 0.0F, -0.136659280431156F);
        this.bone2 = new ModelRenderer(this, 0, 128);
        this.bone2.setRotationPoint(0.0F, 0.0F, -14.0F);
        this.bone2.addBox(-3.0F, -1.0F, -3.0F, 6, 1, 3, 0.0F);
        this.setRotateAngle(bone2, 0.045553093477052F, 0.0F, 0.0F);
        this.bonemidl = new ModelRenderer(this, 34, 122);
        this.bonemidl.setRotationPoint(4.0F, -16.0F, 0.0F);
        this.bonemidl.addBox(0.0F, -1.0F, -2.0F, 2, 1, 4, 0.0F);
        this.ropeconnection_f2r = new ModelRenderer(this, 132, 8);
        this.ropeconnection_f2r.setRotationPoint(-5.0F, 1.0F, 0.0F);
        this.ropeconnection_f2r.addBox(-1.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.base_edge2b = new ModelRenderer(this, 58, 195);
        this.base_edge2b.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.base_edge2b.addBox(-3.0F, -2.0F, -1.0F, 6, 2, 1, 0.0F);
        this.balloon_side4r = new ModelRenderer(this, 200, 68);
        this.balloon_side4r.setRotationPoint(-9.0F, 0.0F, 0.0F);
        this.balloon_side4r.addBox(-10.0F, 0.0F, -12.0F, 10, 16, 12, 0.0F);
        this.setRotateAngle(balloon_side4r, 0.0F, 0.0F, -0.136659280431156F);
        this.ropeconnection_f1l = new ModelRenderer(this, 139, 11);
        this.ropeconnection_f1l.setRotationPoint(5.0F, 1.0F, 0.0F);
        this.ropeconnection_f1l.addBox(-1.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.rope_back_left1 = new ModelRenderer(this, 38, 203);
        this.rope_back_left1.setRotationPoint(3.0F, 0.0F, 4.0F);
        this.rope_back_left1.addBox(0.0F, -16.0F, 0.0F, 1, 16, 1, 0.0F);
        this.setRotateAngle(rope_back_left1, -1.2292353921796064F, 1.0471975511965976F, 0.0F);
        this.supportbeam_back1r = new ModelRenderer(this, 0, 4);
        this.supportbeam_back1r.setRotationPoint(-12.0F, 0.0F, 0.0F);
        this.supportbeam_back1r.addBox(-7.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(supportbeam_back1r, 0.0F, 0.0F, -0.22759093446006054F);
        this.balloon_main2 = new ModelRenderer(this, 76, 0);
        this.balloon_main2.setRotationPoint(0.0F, -16.0F, 0.0F);
        this.balloon_main2.addBox(-9.0F, 0.0F, -20.0F, 18, 16, 20, 0.0F);
        this.setRotateAngle(balloon_main2, 0.045553093477052F, 0.0F, 0.0F);
        this.supportbeam_back1l = new ModelRenderer(this, 132, 4);
        this.supportbeam_back1l.setRotationPoint(12.0F, 0.0F, 0.0F);
        this.supportbeam_back1l.addBox(0.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(supportbeam_back1l, 0.0F, 0.0F, 0.22759093446006054F);
        this.ropeconnection_b1r = new ModelRenderer(this, 86, 3);
        this.ropeconnection_b1r.setRotationPoint(-5.0F, 1.0F, 0.0F);
        this.ropeconnection_b1r.addBox(-1.0F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.bone3 = new ModelRenderer(this, 19, 122);
        this.bone3.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.bone3.addBox(-2.0F, -1.0F, 0.0F, 4, 1, 3, 0.0F);
        this.setRotateAngle(bone3, -0.045553093477052F, 0.0F, 0.0F);
        this.balloon_side1r = new ModelRenderer(this, 192, 8);
        this.balloon_side1r.setRotationPoint(-9.0F, 0.0F, 0.0F);
        this.balloon_side1r.addBox(-10.0F, 0.0F, 0.0F, 10, 16, 20, 0.0F);
        this.setRotateAngle(balloon_side1r, 0.0F, 0.0F, -0.136659280431156F);
        this.supportbeam_front2m.addChild(this.supportbeam_front2r);
        this.balloon_side3r.addChild(this.skin3r);
        this.supportbeam_front1r.addChild(this.ropeconnection_f1r);
        this.vial_base.addChild(this.vial_bottom);
        this.balloon_main3.addChild(this.balloon_side3l);
        this.base_main.addChild(this.rope_front_left1);
        this.balloon_mainrotation.addChild(this.base_main);
        this.supportbeam_front2m.addChild(this.supportbeam_front2l);
        this.burner_vialconnection1.addChild(this.burner_vialconnection2);
        this.balloon_main2.addChild(this.balloon_main4);
        this.supportbeam_back2m.addChild(this.supportbeam_back2r);
        this.supportbeam_back2r.addChild(this.ropeconnection_b2r);
        this.balloon_main1.addChild(this.bone1);
        this.balloon_side1l.addChild(this.skin1l);
        this.base_main.addChild(this.rope_back_right1);
        this.balloon_main2.addChild(this.supportbeam_front1m);
        this.balloon_side2r.addChild(this.skin2r);
        this.balloon_side2l.addChild(this.skin2l);
        this.vialholder_main.addChild(this.vialholder1);
        this.balloon_main3.addChild(this.supportbeam_back2m);
        this.balloon_main4.addChild(this.baloon_front);
        this.supportbeam_back2m.addChild(this.supportbeam_back2l);
        this.balloon_mainrotation.addChild(this.bonemidr);
        this.base_main.addChild(this.base_edge1a);
        this.balloon_mainrotation.addChild(this.balloon_main1);
        this.balloon_main1.addChild(this.supportbeam_back1m);
        this.supportbeam_back2l.addChild(this.ropeconnection_b2l);
        this.base_main.addChild(this.rope_front_right1);
        this.burner_main.addChild(this.burner_top);
        this.balloon_main4.addChild(this.bone4);
        this.base_main.addChild(this.burner_main);
        this.vial_base.addChild(this.vial_top);
        this.balloon_main4.addChild(this.supportbeam_front2m);
        this.baloon_front.addChild(this.balloon_front_r);
        this.balloon_side1r.addChild(this.skin1r);
        this.balloon_back.addChild(this.balloon_back_r);
        this.baloon_front.addChild(this.balloon_front_l);
        this.balloon_main1.addChild(this.balloon_main3);
        this.balloon_mainrotation.addChild(this.heatvent1);
        this.vialholder_main.addChild(this.vial_base);
        this.vialholder_main.addChild(this.vialholder2);
        this.balloon_main3.addChild(this.balloon_side3r);
        this.balloon_side3l.addChild(this.skin3l);
        this.base_edge1a.addChild(this.base_edge1b);
        this.base_main.addChild(this.vialholder_main);
        this.burner_main.addChild(this.burner_vialconnection1);
        this.balloon_main2.addChild(this.balloon_side2l);
        this.balloon_main4.addChild(this.balloon_side4l);
        this.balloon_main3.addChild(this.balloon_back);
        this.supportbeam_back1l.addChild(this.ropeconnection_b1l);
        this.base_main.addChild(this.base_edge2a);
        this.balloon_main1.addChild(this.balloon_side1l);
        this.heatvent1.addChild(this.heatvent2);
        this.balloon_side4l.addChild(this.skin4l);
        this.supportbeam_front2l.addChild(this.ropeconnection_f2l);
        this.supportbeam_front1m.addChild(this.supportbeam_front1r);
        this.balloon_side4r.addChild(this.skin4r);
        this.balloon_back.addChild(this.balloon_back_l);
        this.supportbeam_front1m.addChild(this.supportbeam_front1l);
        this.balloon_main2.addChild(this.balloon_side2r);
        this.balloon_main2.addChild(this.bone2);
        this.balloon_mainrotation.addChild(this.bonemidl);
        this.supportbeam_front2r.addChild(this.ropeconnection_f2r);
        this.base_edge2a.addChild(this.base_edge2b);
        this.balloon_main4.addChild(this.balloon_side4r);
        this.supportbeam_front1l.addChild(this.ropeconnection_f1l);
        this.base_main.addChild(this.rope_back_left1);
        this.supportbeam_back1m.addChild(this.supportbeam_back1r);
        this.balloon_mainrotation.addChild(this.balloon_main2);
        this.supportbeam_back1m.addChild(this.supportbeam_back1l);
        this.supportbeam_back1r.addChild(this.ropeconnection_b1r);
        this.balloon_main3.addChild(this.bone3);
        this.balloon_main1.addChild(this.balloon_side1r);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	this.render(f5);
    }
    
    public void render(float scale) { 
    	this.vialholder_main.showModel = false;
        this.balloon_mainrotation.render(scale);
        this.vialholder_main.showModel = true;
        
        //render vial in second pass for proper blending
        GlStateManager.pushMatrix();
        GlStateManager.translate(0, -13.0f / 16.0f, 0);
        this.vialholder_main.render(scale);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
