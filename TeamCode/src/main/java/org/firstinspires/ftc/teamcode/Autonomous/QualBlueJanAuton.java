package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Crane;

@Autonomous(name="Qual Blue Block Autonomous", group = "AAA")
public class QualBlueJanAuton extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        setup(runtime, Crane.setupType.drive, Crane.setupType.foundation, Crane.setupType.claw, Crane.setupType.ultrasoinc, Crane.setupType.autonomous);

        if(opModeIsActive()){
            while(rob.MaglimitSwitch.getState()) {
                rob.driveTrainMovement(1, Crane.movements.linearUp);
            }
            while(rob.MaglimitSwitch2.getState()) {
                rob.driveTrainMovement(1, Crane.movements.clawOut);
            }
            rob.rightServo.setPosition(0.70);
        }
    }
}
