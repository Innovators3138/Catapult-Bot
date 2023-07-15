package frc.robot;

import java.util.ArrayList;
import java.util.List;

public class DriveMode {
    private final String name;
    private final boolean rawMode;
    private final double maxLinAccel;
    private final double maxRotAccel;
    private final double linearMult;
    private final double rotMult;
    private final boolean invertLin;
    public int index = -1;
    private final boolean invertRot;

    public static List<DriveMode> driveModes = new ArrayList<>();

    public DriveMode(Builder builder) {
        this.name = builder.name;
        this.rawMode = builder.rawMode;
        this.maxLinAccel = builder.maxLinAccel;
        this.maxRotAccel = builder.maxRotAccel;
        this.linearMult = builder.linearMult;
        this.rotMult = builder.rotMult;
        this.invertLin = builder.invertLin;
        this.invertRot = builder.invertRot;
        if(builder.addToList) {
            driveModes.add(this);
            index = driveModes.size();
        }
    }

    public String getName() {
        return name;
    }

    public boolean isRawMode() {
        return rawMode;
    }

    public double getMaxLinAccel() {
        return maxLinAccel;
    }

    public double getMaxRotAccel() {
        return maxRotAccel;
    }

    public double getLinearMult() {
        return linearMult;
    }

    public double getRotMult() {
        return rotMult;
    }

    public boolean isInvertLin() {
        return invertLin;
    }

    public boolean isInvertRot() {
        return invertRot;
    }

    public static class Builder {
        private final String name;
        private boolean rawMode = false;
        private double maxLinAccel = 1;
        private double maxRotAccel = 1;
        private double linearMult = 1;
        private double rotMult = 1;
        private boolean invertLin = false;
        private boolean invertRot = false;
        private boolean addToList = true;

        public Builder(String name) {
            this.name = name;
        }

        public Builder rawMode(boolean rawMode) {
            this.rawMode = rawMode;
            return this;
        }

        public Builder maxLinAccel(double maxLinAccel) {
            this.maxLinAccel = maxLinAccel;
            return this;
        }

        public Builder maxRotAccel(double maxRotAccel) {
            this.maxRotAccel = maxRotAccel;
            return this;
        }

        public Builder linearMult(double linearMult) {
            this.linearMult = linearMult;
            return this;
        }

        public Builder rotMult(double rotMult) {
            this.rotMult = rotMult;
            return this;
        }

        public Builder invertLin() {
            this.invertLin = true;
            return this;
        }

        public Builder invertRot() {
            this.invertRot = true;
            return this;
        }

        public Builder addToList(boolean addToList) {
            this.addToList = addToList;
            return this;
        }

        public DriveMode build() {
            return new DriveMode(this);
        }
    }
}
