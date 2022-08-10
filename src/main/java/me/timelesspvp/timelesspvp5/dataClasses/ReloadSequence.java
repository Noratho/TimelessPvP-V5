package me.timelesspvp.timelesspvp5.dataClasses;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.tasks.abstractTask;
import me.timelesspvp.timelesspvp5.tasks.reloadTask;
import org.bukkit.entity.Player;
import org.javatuples.Pair;

import java.util.ArrayList;

public class ReloadSequence {


    private ArrayList<Pair<Long, RunnableData>> rData;
    private Player p;

    private ArrayList<reloadTask> runnables = new ArrayList<>();;

    public ReloadSequence(Player p, ArrayList<Pair<Long, RunnableData>> rData) {
        this.p = p;
        this.rData = rData;
    }

    public void generateSequence() {

        for (Pair<Long, RunnableData> pair : rData) {

            reloadTask reloadRunnable = new reloadTask(p, pair.getValue0(), pair.getValue1());
            runnables.add(reloadRunnable);
        }
    }

    public void runSequence() {

        TimelessPvP5 plugin = TimelessPvP5.getPlugin();

        for (abstractTask task : runnables) {
            task.runTaskLater(plugin, task.getDelay());
        }
    }

    public void cancel() {

        for (reloadTask runnable : runnables) {
            runnable.cancel();
        }
        runnables = new ArrayList<reloadTask>();
    }

}
