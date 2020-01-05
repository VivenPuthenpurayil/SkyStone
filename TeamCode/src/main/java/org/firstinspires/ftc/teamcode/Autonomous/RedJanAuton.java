package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Crane;

@Autonomous(name="Red Block Autonomous", group = "AAA")
public class RedJanAuton extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        setup(runtime, Crane.setupType.drive, Crane.setupType.foundation, Crane.setupType.claw, Crane.setupType.ultrasoinc, Crane.setupType.imu);

        if(opModeIsActive()){
            double dist = 0;
            rob.encodeCoreHexMovement(0.5, 4, 3, 0, Crane.movements.linearUp, rob.rightLinear);
            rob.encodeCoreHexMovement(0.5, 4.75, 3, 0, Crane.movements.clawOut, rob.extend);
            rob.rotationservo.setPosition(0.33);
            rob.rightServo.setPosition(0.4);
            rob.driveTrainEncoderMovement(0.1, 15, 7, 0, Crane.movements.backward);
            do{
                rob.driveTrainMovement(0.1, Crane.movements.backward);
                dist= rob.back.getDistance(DistanceUnit.CM);
                telemetry.addData("cm front", "%.2f cm", dist);
                telemetry.update();

            }
            while(dist > 11.75 || Double.compare(dist, Double.NaN) == 0 && opModeIsActive());
            rob.stopDrivetrain();
            rob.encodeCoreHexMovement(0.5, 5, 2.5, 0, Crane.movements.linearDown, rob.rightLinear);
            rob.rightServo.setPosition(0.27);
            rob.encodeCoreHexMovement(0.5, 2, 2, 0, Crane.movements.linearUp, rob.rightLinear);
            rob.driveTrainEncoderMovement(0.2, 6, 7, 0, Crane.movements.forward);
            rob.driveTrainEncoderMovement(0.5, 20, 3, 0, Crane.movements.ccw);
     //       rob.turn(90, Crane.turnside.ccw, .5, Crane.axis.center);
            rob.encodeCoreHexMovement(0.5, 2, 2, 0, Crane.movements.linearDown, rob.rightLinear);
            rob.driveTrainEncoderMovement(0.5, 50, 7, 0, Crane.movements.backward);
            rob.encodeCoreHexMovement(0.5, 6, 4, 0, Crane.movements.linearUp, rob.rightLinear);
            do{
                rob.driveTrainMovement(0.2, Crane.movements.backward);
                dist= rob.back.getDistance(DistanceUnit.CM);
                telemetry.addData("cm front", "%.2f cm", dist);
                telemetry.update();

            }
            while(dist > 65 || Double.compare(dist, Double.NaN) == 0 && opModeIsActive());
            rob.stopDrivetrain();
            rob.driveTrainEncoderMovement(0.5, 20, 3, 0, Crane.movements.cw);

            //      rob.turn(90, Crane.turnside.cw, .5, Crane.axis.center);
            rob.driveTrainEncoderMovement(0.4, 24, 7, 0, Crane.movements.backward);
            rob.driveTrainEncoderMovement(0.15, 6, 7, 0, Crane.movements.backward);

            rob.encodeCoreHexMovement(0.5, 3, 2, 0, Crane.movements.linearDown, rob.rightLinear);
            rob.rightServo.setPosition(0.8);
            rob.encodeCoreHexMovement(0.5, 3, 2, 0, Crane.movements.linearUp, rob.rightLinear);


            rob.driveTrainEncoderMovement(0.2, 10, 7, 0, Crane.movements.forward);

            rob.encodeCoreHexMovement(0.5, 4, 2, 0, Crane.movements.linearDown, rob.rightLinear);

            rob.driveTrainEncoderMovement(0.5, 50, 7, 0, Crane.movements.left);


        }
    }
}
