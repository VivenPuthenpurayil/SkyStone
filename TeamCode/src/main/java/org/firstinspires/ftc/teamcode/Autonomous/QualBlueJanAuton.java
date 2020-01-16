package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Crane;

@Autonomous(name="Qual Blue Jan Autonomous", group = "AAA")
public class QualBlueJanAuton extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        setup(runtime, Crane.setupType.drive, Crane.setupType.foundation, Crane.setupType.claw, Crane.setupType.ultrasoinc, Crane.setupType.autonomous);

        if(opModeIsActive()){
            double dist = 0;
            do{
                rob.driveTrainMovement(0.3, Crane.movements.left);

                dist= rob.left.getDistance(DistanceUnit.CM);
                telemetry.addData("cm front", "%.2f cm", dist);
                telemetry.update();

            }
            while(dist > 10 || Double.compare(dist, Double.NaN) == 0 && opModeIsActive());

            rob.autonGrabClaw.setPosition(0.4);
            sleep(100);
            rob.autonDownClaw.setPosition(1);
            sleep(100);
            rob.autonGrabClaw.setPosition(0.15);
            sleep(100);
            rob.autonDownClaw.setPosition(0.5);
            sleep(100);

            do{
                rob.driveTrainMovement(0.3, Crane.movements.right);

                dist= rob.right.getDistance(DistanceUnit.CM);
                telemetry.addData("cm front", "%.2f cm", dist);
                telemetry.update();

            }
            while(dist > 40 || Double.compare(dist, Double.NaN) == 0 && opModeIsActive());

            rob.driveTrainEncoderMovement(0.3, 40, 4, 0, Crane.movements.right);

            do{
                rob.driveTrainMovement(0.3, Crane.movements.backward);

                dist= rob.back.getDistance(DistanceUnit.CM);
                telemetry.addData("cm front", "%.2f cm", dist);
                telemetry.update();

            }
            while(dist > 30 || Double.compare(dist, Double.NaN) == 0 && opModeIsActive());

            rob.autonDownClaw.setPosition(1);
            sleep(100);
            rob.autonGrabClaw.setPosition(0.4);
            sleep(100);
            rob.autonDownClaw.setPosition(0.5);
            sleep(100);
            rob.autonGrabClaw.setPosition(0.15);
            sleep(100);

            rob.foundationServo1.setPosition(0.45);
            rob.foundationServo2.setPosition(0.75);

            rob.driveTrainEncoderMovement(0.5, 25, 5, 0, Crane.movements.ccw);

            rob.driveTrainEncoderMovement(0.4, 20, 4, 0, Crane.movements.left);

            rob.driveTrainEncoderMovement(0.4, 20, 4, 0, Crane.movements.backward);

            rob.foundationServo1.setPosition(1);
            rob.foundationServo2.setPosition(0);

            rob.driveTrainEncoderMovement(0.4, 5, 4, 0, Crane.movements.right);

            rob.driveTrainEncoderMovement(0.4, 10, 4, 0, Crane.movements.forward);


            rob.driveTrainEncoderMovement(0.4, 20, 4, 0, Crane.movements.right);







        }
    }
}
