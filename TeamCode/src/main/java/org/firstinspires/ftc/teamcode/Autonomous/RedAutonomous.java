package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Crane;

@Autonomous(name="Red Autonomous", group = "basic")
public class RedAutonomous extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        setup(runtime, Crane.setupType.drive, Crane.setupType.foundation);

        if(opModeIsActive()){
            //rob.driveTrainEncoderMovement(0.7, 3, 3, 2000, Crane.movements.forward);
            rob.foundationServo1.setPosition(0.9);
            rob.foundationServo2.setPosition(0.1);

            //rob.encodeCoreHexMovement(0.7, 3, 5, 100, Crane.movements.linearUp);
        }
    }
}
