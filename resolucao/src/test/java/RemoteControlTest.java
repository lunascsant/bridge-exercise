package com.ifood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemoteControlTest {
    private Television television;
    private Radio radio;
    private RemoteControl tvRemote;
    private RemoteControl radioRemote;

    @BeforeEach
    void setUp() {
        television = new Television();
        radio = new Radio();
        tvRemote = new RemoteControl(television);
        radioRemote = new RemoteControl(radio);
    }

    @Test
    void shouldTogglePowerOnOffDevice() {
        assertFalse(television.isEnabled());
        tvRemote.togglePower();
        assertTrue(television.isEnabled());
        tvRemote.togglePower();
        assertFalse(television.isEnabled());
    }

    @Test
    void shouldIncreaseVolume() {
        int initialVolume = television.getVolume();
        tvRemote.volumeUp();
        assertEquals(initialVolume + 10, television.getVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        int initialVolume = television.getVolume();
        tvRemote.volumeDown();
        assertEquals(initialVolume - 10, television.getVolume());
    }

    @Test
    void shouldIncreaseChannel() {
        int initialChannel = television.getChannel();
        tvRemote.channelUp();
        assertEquals(initialChannel + 1, television.getChannel());
    }

    @Test
    void shouldDecreaseChannel() {
        int initialChannel = television.getChannel();
        tvRemote.channelDown();
        assertEquals(initialChannel - 1, television.getChannel());
    }

    @Test
    void shouldWorkWithDifferentDevices() {
        radioRemote.togglePower();
        assertTrue(radio.isEnabled());

        radioRemote.volumeUp();
        assertEquals(40, radio.getVolume());

        radioRemote.channelUp();
        assertEquals(2, radio.getChannel());
    }

    @Test
    void shouldRespectVolumeConstraints() {
        television.setVolume(95);
        tvRemote.volumeUp();
        assertEquals(100, television.getVolume());

        television.setVolume(5);
        tvRemote.volumeDown();
        assertEquals(0, television.getVolume());
    }
}
