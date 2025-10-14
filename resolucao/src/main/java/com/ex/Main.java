package com.ex;

public class Main {
    public static void main(String[] args) {
        Television tv = new Television();
        Radio radio = new Radio();

        RemoteControl basicRemote = new RemoteControl(tv);
        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio);

        basicRemote.togglePower();
        basicRemote.volumeUp();
        basicRemote.channelUp();
        tv.printStatus();

        advancedRemote.togglePower();
        advancedRemote.setVolume(75);
        advancedRemote.setChannel(5);
        advancedRemote.mute();
        radio.printStatus();
    }
}