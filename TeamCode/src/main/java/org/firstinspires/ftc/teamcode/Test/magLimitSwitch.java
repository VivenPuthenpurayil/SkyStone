package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Crane;

@Autonomous(name="Magnetic Limit Switch", group = "basic")
public class magLimitSwitch extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        setup(runtime, Crane.setupType.claw);
        telemetry.addLine("Start!");
        telemetry.update();

        while (opModeIsActive()) {
            telemetry.addData("State", rob.MaglimitSwitch.getState());
            /*
            if(rob.MaglimitSwitch.getState()){
                telemetry.addData("State True", rob.MaglimitSwitch.getState());
                rob.MaglimitSwitch.setState(false);
            }else if(!rob.MaglimitSwitch.getState()){
                    telemetry.addData("State False", rob.MaglimitSwitch.getState());
                    rob.MaglimitSwitch.setState(true);
            }
             */

            telemetry.update();
        }


    }
}
