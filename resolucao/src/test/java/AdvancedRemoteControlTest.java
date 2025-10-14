package com.ifood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdvancedRemoteControlTest {
    private Television television;
    private Radio radio;
    private AdvancedRemoteControl tvAdvancedRemote;
    private AdvancedRemoteControl radioAdvancedRemote;

    @BeforeEach
    void setUp() {
        television = new Television();
        radio = new Radio();
        tvAdvancedRemote = new AdvancedRemoteControl(television);
        radioAdvancedRemote = new AdvancedRemoteControl(radio);
    }

    @org.junit.Test
    void shouldInheritBasicRemoteControlFunctionality() {
        assertFalse(television.isEnabled());
        tvAdvancedRemote.togglePower();
        assertTrue(television.isEnabled());

        int initialVolume = television.getVolume();
        tvAdvancedRemote.volumeUp();
        assertEquals(initialVolume + 10, television.getVolume());

        int initialChannel = television.getChannel();
        tvAdvancedRemote.channelUp();
        assertEquals(initialChannel + 1, television.getChannel());
    }

    @Test
    void shouldMuteDevice() {
        television.setVolume(50);
        tvAdvancedRemote.mute();
        assertEquals(0, television.getVolume());
    }

    @Test
    void shouldSetMaxVolume() {
        television.setVolume(20);
        tvAdvancedRemote.setMaxVolume();
        assertEquals(100, television.getVolume());
    }

    @Test
    void shouldSetSpecificChannel() {
        tvAdvancedRemote.setChannel(15);
        assertEquals(15, television.getChannel());
    }

    @Test
    void shouldSetSpecificVolume() {
        tvAdvancedRemote.setVolume(75);
        assertEquals(75, television.getVolume());
    }

    @Test
    void shouldSetVolumeWithConstraints() {
        tvAdvancedRemote.setVolume(150);
        assertEquals(100, television.getVolume());

        tvAdvancedRemote.setVolume(-10);
        assertEquals(0, television.getVolume());
    }

    @Test
    void shouldWorkWithDifferentDevices() {
        radioAdvancedRemote.togglePower();
        assertTrue(radio.isEnabled());

        radioAdvancedRemote.setVolume(80);
        assertEquals(80, radio.getVolume());

        radioAdvancedRemote.setChannel(7);
        assertEquals(7, radio.getChannel());

        radioAdvancedRemote.mute();
        assertEquals(0, radio.getVolume());
    }

    @Test
    void shouldCombineAdvancedAndBasicFeatures() {
        tvAdvancedRemote.togglePower();
        tvAdvancedRemote.setVolume(60);
        tvAdvancedRemote.volumeUp();
        assertEquals(70, television.getVolume());

        tvAdvancedRemote.setChannel(5);
        tvAdvancedRemote.channelDown();
        assertEquals(4, television.getChannel());
    }
}
