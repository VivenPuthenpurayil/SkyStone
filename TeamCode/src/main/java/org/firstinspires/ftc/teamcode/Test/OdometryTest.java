package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Crane;

@Autonomous(name="Odometry Test", group = "Smart")
public class OdometryTest extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        //setup(runtime, Crane.setupType.encoder);

        int startPosition = rob.encoderup.getCurrentPosition();
        int startPositionRS = rob.rightSuck.getCurrentPosition();
        int startPositionLS = rob.leftSuck.getCurrentPosition();
        while(opModeIsActive()){

            telemetry.addData("Current Encoder Position: ", rob.encoderup.getCurrentPosition() - startPosition);
            telemetry.addData("Current RS Position: ", rob.rightSuck.getCurrentPosition() - startPositionRS);
            telemetry.addData("Current LS Position: ", rob.leftSuck.getCurrentPosition() - startPositionLS);

            telemetry.update();
        }
    }
}
