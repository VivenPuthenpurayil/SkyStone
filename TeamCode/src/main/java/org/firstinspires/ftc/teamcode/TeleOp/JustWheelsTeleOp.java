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

        setup(runtime, Crane.setupType.drive, Crane.setupType.intake);

        while (opModeIsActive()){
            standardGamepadData();

            if(gamepad1.dpad_up){
                rob.rightSuck.setPower(-0.8);
                rob.leftSuck.setPower(0.8);
                rob.smallRSuck.setPower(-1);
                rob.smallLSuck.setPower(1);
            }else if(gamepad1.dpad_down){
                rob.rightSuck.setPower(0.8);
                rob.leftSuck.setPower(-0.8);
                rob.smallRSuck.setPower(1);
                rob.smallLSuck.setPower(-1);
            }else{
                rob.rightSuck.setPower(0);
                rob.leftSuck.setPower(0);
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
                    rob.driveTrainMovement(0.4, Crane.movements.ccw);
                } else if (g(9)) {
                    rob.driveTrainMovement(0.4, Crane.movements.cw);
                } else {
                    rob.stopDrivetrain();
                }
            }
            else {
                if (g(0)) {
                    rob.driveTrainMovement(0.1, Crane.movements.forward);
                } else if (g(2)) {
                    rob.driveTrainMovement(0.1, Crane.movements.backward);
                } else if (g(3)) {
                    rob.driveTrainMovement(0.1, Crane.movements.right);
                } else if (g(1)) {
                    rob.driveTrainMovement(0.1, Crane.movements.left);
                }
                else if (g(4)) {
                    rob.driveTrainMovement(0.1, Crane.movements.tr);
                }else if (g(5)) {
                    rob.driveTrainMovement(0.1, Crane.movements.tl);
                }else if (g(6)) {
                    rob.driveTrainMovement(0.1, Crane.movements.bl);
                }else if (g(7)) {
                    rob.driveTrainMovement(0.1, Crane.movements.br);
                }
                else if (g(8)) {
                    rob.driveTrainMovement(0.1, Crane.movements.ccw);
                } else if (g(9)) {
                    rob.driveTrainMovement(0.1, Crane.movements.cw);
                } else {
                    rob.stopDrivetrain();
                }
            }

            telemetry.addData("power", fb);
            telemetry.addData("crawl", yToggle);
            telemetry.update();

        }
    }
}
