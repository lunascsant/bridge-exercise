package com.ifood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    private Radio radio;

    @BeforeEach
    void setUp() {
        radio = new Radio();
    }

    @Test
    void shouldInitializeWithDefaultValues() {
        assertFalse(radio.isEnabled());
        assertEquals(30, radio.getVolume());
        assertEquals(1, radio.getChannel());
    }

    @Test
    void shouldEnableDevice() {
        radio.enable();
        assertTrue(radio.isEnabled());
    }

    @Test
    void shouldDisableDevice() {
        radio.enable();
        radio.disable();
        assertFalse(radio.isEnabled());
    }

    @Test
    void shouldSetValidVolume() {
        radio.setVolume(60);
        assertEquals(60, radio.getVolume());
    }

    @Test
    void shouldLimitVolumeToMaximum() {
        radio.setVolume(200);
        assertEquals(100, radio.getVolume());
    }

    @Test
    void shouldLimitVolumeToMinimum() {
        radio.setVolume(-20);
        assertEquals(0, radio.getVolume());
    }

    @Test
    void shouldSetChannel() {
        radio.setChannel(10);
        assertEquals(10, radio.getChannel());
    }

    @Test
    void shouldPrintStatus() {
        assertDoesNotThrow(() -> radio.printStatus());
    }
}
