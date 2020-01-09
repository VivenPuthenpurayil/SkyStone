package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Crane;

@Autonomous(name="Blue Foundation Autonomous", group = "AAA")
public class BlueJanAutonFound extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        setup(runtime, Crane.setupType.drive, Crane.setupType.foundation, Crane.setupType.claw, Crane.setupType.ultrasoinc
        );

        if(opModeIsActive()) {
            rob.driveTrainEncoderMovement(0.5, 15, 5, 0, Crane.movements.right);
            rob.driveTrainEncoderMovement(0.3, 28, 8, 0, Crane.movements.backward);
            sleep(1000);
            rob.foundationServo1.setPosition(0.40);
            rob.foundationServo2.setPosition(0.70);
            sleep(1000);
            rob.driveTrainEncoderMovement(0.5, 50, 8, 0, Crane.movements.ccw);
            rob.driveTrainEncoderMovement(0.5, 40, 5, 0, Crane.movements.right);
            rob.driveTrainEncoderMovement(0.5, 10, 5, 0, Crane.movements.forward);


        }
    }
}
