package me.sshcrack.randomstuff.util.test.events;/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */


import org.jetbrains.annotations.ApiStatus;

public class TitleRenderEvent extends Event
{
    @ApiStatus.Internal
    public TitleRenderEvent()
    {
    }

    public String getTest() {
        return "hi lol";
    }
}
