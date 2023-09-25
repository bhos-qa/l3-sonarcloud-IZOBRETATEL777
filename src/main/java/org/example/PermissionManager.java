package org.example;

import lombok.Getter;
import lombok.Setter;

public class PermissionManager {

    @Getter
    @Setter
    private PermissionLevel mCurrentLevel = PermissionLevel.USER;
}
