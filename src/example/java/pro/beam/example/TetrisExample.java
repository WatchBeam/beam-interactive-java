package pro.beam.example;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import pro.beam.api.BeamAPI;
import pro.beam.interactive.robot.Robot;
import pro.beam.interactive.robot.RobotBuilder;

public class TetrisExample {
    public static void main(String[] args) {
        BeamAPI beam = new BeamAPI();

        ListenableFuture<Robot> future = new RobotBuilder().username("<username>")
                                                           .password("<password>")
                                                           .channel(127)
                                                           .build(beam);

        Futures.addCallback(future, new FutureCallback<Robot>() {
            @Override public void onSuccess(Robot robot) {
                // The robot is ready to be used.
            }

            @Override public void onFailure(Throwable throwable) {
                // There was an error connecting to the socket.
            }
        });
    }
}
