package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Crane;

@Autonomous(name="Straight Right", group = "AAA")
public class straightRight extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        setup(runtime, Crane.setupType.drive, Crane.setupType.claw);
        telemetry.addLine("Start!");
        telemetry.update();

        if (opModeIsActive()){
            rob.encodeCoreHexMovement(0.5, 3, 3, 0, Crane.movements.linearUp, rob.rightLinear);
            rob.encodeCoreHexMovement(0.5, 4.50, 3, 0, Crane.movements.clawOut, rob.extend);
            rob.encodeCoreHexMovement(0.5, 4, 3, 0, Crane.movements.linearDown, rob.rightLinear);
            rob.rotationservo.setPosition(0.33);
            rob.rightServo.setPosition(0.55);
            rob.driveTrainEncoderMovement(0.2, 21.5, 5, 0, Crane.movements.backward);
            rob.driveTrainEncoderMovement(0.2, 40, 5, 0, Crane.movements.left);

        }


    }
}
//hello viven
////finish the sentence//// you are a nig
