package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Crane;

@Autonomous(name="Blue Auton", group = "basic")
public class basicOp extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        setup(runtime, Crane.setupType.drive, Crane.setupType.foundation, Crane.setupType.claw);
        telemetry.addLine("Start!");
        telemetry.update();

        if (opModeIsActive()){

            rob.driveTrainEncoderMovement(0.2, 40, 10, 50000, Crane.movements.right);
            //rob.driveTrainMovement(0.25, Crane.movements.right);
            sleep(4000);
            //rob.driveTrainMovement(0.5, Crane.movements.forward);
            sleep(2500);

        }


    }
}
