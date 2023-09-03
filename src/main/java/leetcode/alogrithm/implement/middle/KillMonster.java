package main.java.leetcode.alogrithm.implement.middle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KillMonster {

    public static int eliminateMaximum(int[] dist, int[] speed) {
        if (dist == null) {
            return 0;
        }
        List<Monster> monsterList = new ArrayList<>();
        for (int i = 0; i < dist.length; i++) {
            Monster monster = new Monster(dist[i], speed[i]);
            monsterList.add(monster);
        }
        monsterList.sort(Comparator.comparingInt(o -> o.arriveTime));
        int i;
        for (i = 1; i < monsterList.size(); i++) {
            if (monsterList.get(i).getArriveTime() <= i) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(eliminateMaximum(new int[]{3, 5, 7, 4, 5}, new int[]{2, 3, 6, 3, 2}));
    }

    private static class Monster {
        private Integer distance;
        private Integer speed;
        private Integer arriveTime;

        Monster(Integer distance, Integer speed) {
            this.distance = distance;
            this.speed = speed;
            this.arriveTime = distance / speed;
            if (distance % speed > 0) {
                arriveTime++;
            }
        }

        public Integer getArriveTime() {
            return this.arriveTime;
        }
    }
}
