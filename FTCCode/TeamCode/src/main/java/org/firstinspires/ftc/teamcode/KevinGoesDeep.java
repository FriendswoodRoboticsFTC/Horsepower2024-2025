package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="KevinGoesDeep")
public class KevinGoesDeep extends LinearOpMode {



    @Override
    public void runOpMode(){

        Chassis chassis = new Chassis(hardwareMap);

        waitForStart();

        while (opModeIsActive()){
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = -gamepad1.left_stick_x; // Counteract imperfect strafing  :  * 1
            double rx = gamepad1.right_stick_x;


            chassis.setMove(y,x,rx);
        }
    }

}
