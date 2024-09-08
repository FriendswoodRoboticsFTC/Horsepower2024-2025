package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Chassis {
    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backRightMotor;

    public Chassis(HardwareMap hardwareMap) {
        frontLeftMotor = hardwareMap.get(DcMotor.class,Constants.Motors.FRONT_LEFT);
        frontRightMotor = hardwareMap.get(DcMotor.class,Constants.Motors.FRONT_RIGHT);
        backLeftMotor = hardwareMap.get(DcMotor.class,Constants.Motors.BACK_LEFT);
        backRightMotor = hardwareMap.get(DcMotor.class,Constants.Motors.BACK_RIGHT);

        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setMove(double vertical, double horizontal, double turnAmount) {
        //1 1 would be up & right
        double frontLeftSpeed = 0;
        double frontRightSpeed = 0;
        double backLeftSpeed = 0;
        double backRightSpeed = 0;


        frontLeftSpeed += vertical;
        frontRightSpeed += vertical;
        backLeftSpeed += vertical;
        backRightSpeed += vertical;
        //1

        frontLeftSpeed += -1 * (horizontal);
        //0
        frontRightSpeed += horizontal;
        //2
        backLeftSpeed += horizontal;
        //2
        backRightSpeed += -1 * (horizontal);
        //0


        frontLeftSpeed += turnAmount;
        frontRightSpeed += (turnAmount) * -1;
        backLeftSpeed += turnAmount;
        backRightSpeed += (turnAmount) * -1;

        frontLeftMotor.setPower(frontLeftSpeed);
        frontRightMotor.setPower(frontRightSpeed);
        backLeftMotor.setPower(backLeftSpeed);
        backRightMotor.setPower(backRightSpeed);
    }
}