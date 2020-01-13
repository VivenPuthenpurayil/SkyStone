package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.Crane;
import org.firstinspires.ftc.teamcode.Control.TeleOpControl;

import static org.firstinspires.ftc.teamcode.Control.Constants.autonDownClaws;
import static org.firstinspires.ftc.teamcode.Control.Constants.autonGrabClaws;

@Autonomous(name = "Auton Claw Test", group = "Concept")



public class AutonClawTest extends TeleOpControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        setup(runtime, Crane.setupType.autonomous);

        if (opModeIsActive()){
            rob.autonGrabClaw.setPosition(0.4);
            sleep(1000);
            rob.autonDownClaw.setPosition(1);
            sleep(1000);
            rob.autonGrabClaw.setPosition(0.15);
            sleep(1000);
            rob.autonDownClaw.setPosition(0.5);
            sleep(1000);
        }
    }
}
