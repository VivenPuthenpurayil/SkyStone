package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.Crane;
import org.firstinspires.ftc.teamcode.Control.TeleOpControl;

@TeleOp(name = "WheelTeleOp", group = "Concept")



public class JustWheelsTeleOp extends TeleOpControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        boolean yToggle = false;

        setup(runtime, Crane.setupType.drive, Crane.setupType.intake, Crane.setupType.claw, Crane.setupType.foundation, Crane.setupType.autonomous);

        while (opModeIsActive()){
            standardGamepadData();

            if(gamepad1.left_trigger>.1){
                rob.rightSuck.setPower(-1);
                rob.leftSuck.setPower(1);
                rob.smallRSuck.setPower(1);
                rob.smallLSuck.setPower(-1);
            }else if(gamepad1.right_trigger>.1){
                rob.rightSuck.setPower(1);
                rob.leftSuck.setPower(-1);
                rob.smallRSuck.setPower(-1);
                rob.smallLSuck.setPower(1);
            }else{
                rob.rightSuck.setPower(0);
                rob.leftSuck.setPower(0);
                rob.smallRSuck.setPower(0);
                rob.smallLSuck.setPower(0);
            }

            if(gamepad1.dpad_up){
                rob.foundationServo1.setPosition(1);
                rob.foundationServo2.setPosition(0);
            }else if (gamepad1.dpad_down) {
                rob.foundationServo1.setPosition(0.45);
                rob.foundationServo2.setPosition(0.75);
            }

            if (gamepad1.y){
                yToggle = !yToggle;
            }



            if (!yToggle) {
                if (g(0)) {
                    rob.driveTrainMovement(fb, Crane.movements.forward);
                } else if (g(2)) {
                    rob.driveTrainMovement(fb, Crane.movements.backward);
                } else if (g(3)) {
                    rob.driveTrainMovement(rl, Crane.movements.right);
                } else if (g(1)) {
                    rob.driveTrainMovement(rl, Crane.movements.left);
                }
                else if (g(4)) {
                    rob.driveTrainMovement(diagonalSpeed, Crane.movements.tr);
                }else if (g(5)) {
                    rob.driveTrainMovement(diagonalSpeed, Crane.movements.tl);
                }else if (g(6)) {
                    rob.driveTrainMovement(diagonalSpeed, Crane.movements.bl);
                }else if (g(7)) {
                    rob.driveTrainMovement(diagonalSpeed, Crane.movements.br);
                }
                else if (g(8)) {
                    rob.driveTrainMovement(0.3, Crane.movements.ccw);
                } else if (g(9)) {
                    rob.driveTrainMovement(0.3, Crane.movements.cw);
                } else {
                    rob.stopDrivetrain();
                }
            }
            else {
                if (g(0)) {
                    rob.driveTrainMovement(0.5, Crane.movements.left);
                } else if (g(2)) {
                    rob.driveTrainMovement(0.5, Crane.movements.right);
                } else if (g(3)) {
                    rob.driveTrainMovement(0.3, Crane.movements.forward);
                } else if (g(1)) {
                    rob.driveTrainMovement(0.3, Crane.movements.backward);
                }
                else if (g(4)) {
                    rob.driveTrainMovement(0.3, Crane.movements.tr);
                }else if (g(5)) {
                    rob.driveTrainMovement(0.3, Crane.movements.tl);
                }else if (g(6)) {
                    rob.driveTrainMovement(0.3, Crane.movements.bl);
                }else if (g(7)) {
                    rob.driveTrainMovement(0.3, Crane.movements.br);
                }
                else if (g(8)) {
                    rob.driveTrainMovement(0.3, Crane.movements.ccw);
                } else if (g(9)) {
                    rob.driveTrainMovement(0.3, Crane.movements.cw);
                } else {
                    rob.stopDrivetrain();
                }
            }
/*
            if(gamepad2.dpad_up){
                rob.rightLinear.setPower(1);
            }
            else if (gamepad2.dpad_down){
                rob.rightLinear.setPower(-0.5);
            }
            else {
                rob.rightLinear.setPower(0);
            }

 */
//check point
            if (gamepad2.a){
                rob.rightServo.setPosition(0.50);
            }
            else if (gamepad2.b){
                rob.rightServo.setPosition(0.70);
            }

            if (gamepad2.y){
                rob.rotationservo.setPosition(0.35);
            }
            else if (gamepad2.x){
                rob.rotationservo.setPosition(0.02);
                rob.rightServo.setPosition(0.70);

                while(rob.MaglimitSwitch2.getState()){
                    rob.extend.setPower(-0.5);
                }
                rob.extend.setPower(0);
                while(rob.MaglimitSwitch.getState()){
                    rob.rightLinear.setPower(0.2);
                }
                rob.rightLinear.setPower(0);
            }

            if(gamepad2.dpad_down){
                while(rob.MaglimitSwitch.getState()){
                    rob.rightLinear.setPower(0.5);
                }
            }else if(gamepad2.dpad_up){
                while(rob.MaglimitSwitch.getState()){
                    rob.rightLinear.setPower(-1);
                }
            }

            if(gamepad2.right_trigger>0.5){
                rob.rotationservo.setPosition(rob.rotationservo.getPosition() - 0.001);
            }else if (gamepad2.left_trigger>0.5) {
                rob.rotationservo.setPosition(rob.rotationservo.getPosition() + 0.001);
            }

            telemetry.addData("right servo pos: ",  rob.rightServo.getPosition());

            if ((f(0) && rob.MaglimitSwitch.getState()) || (f(0) && gamepad2.left_bumper)) {
                rob.rightLinear.setPower(-1);
            } else if ((f(2) && rob.MaglimitSwitch.getState()) || (f(2) && gamepad2.left_bumper)){
                rob.rightLinear.setPower(0.5);
            } else if ((f(3)  && rob.MaglimitSwitch2.getState()) || (f(3) && gamepad2.left_bumper)) {
                rob.extend.setPower(0.5);
            } else if ((f(1)  && rob.MaglimitSwitch2.getState()) || (f(1) && gamepad2.left_bumper)) {
                rob.extend.setPower(-0.5);
            }else{
                rob.extend.setPower(0);
                rob.rightLinear.setPower(0);

            }
/*
            if (gamepad2.dpad_right){
                rob.extend.setPower(-0.5);
            }
            else if (gamepad2.dpad_left){
                rob.extend.setPower(0.5);
            }

 */



            telemetry.addData("rotation servo pos: ",  rob.rotationservo.getPosition());

            telemetry.addData("power", fb);
            telemetry.addData("crawl", yToggle);
            telemetry.update();

        }
    }
}
