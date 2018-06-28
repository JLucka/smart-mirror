package com.jlucka.mirror.service;

import org.springframework.stereotype.Service;

@Service
public class ReloadService {
    private boolean shouldReload;

    public synchronized void setReload() {
        shouldReload = true;
    }

    public synchronized boolean checkAndClear() {
        if (shouldReload) {
            shouldReload = false;
            return true;
        } else {
            return false;
        }
    }
}
