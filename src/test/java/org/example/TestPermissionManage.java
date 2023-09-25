package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPermissionManage {

    private PermissionManager permissionManager;

    @BeforeEach
    public void setUp() {
        this.permissionManager = new PermissionManager();
    }

    @Test
    public void testSetMPermissionLevel() {
        permissionManager.setMCurrentLevel(PermissionLevel.ADMIN);
        assertEquals(PermissionLevel.ADMIN, permissionManager.getMCurrentLevel());

        permissionManager.setMCurrentLevel(PermissionLevel.DEVELOP);
        assertEquals(PermissionLevel.DEVELOP, permissionManager.getMCurrentLevel());

        permissionManager.setMCurrentLevel(PermissionLevel.USER);
        assertEquals(PermissionLevel.USER, permissionManager.getMCurrentLevel());
    }

    @Test
    public void testGetMPermissionLevel() {
        permissionManager.setMCurrentLevel(PermissionLevel.ADMIN);
        assertEquals(PermissionLevel.ADMIN, permissionManager.getMCurrentLevel());

        permissionManager.setMCurrentLevel(PermissionLevel.DEVELOP);
        assertEquals(PermissionLevel.DEVELOP, permissionManager.getMCurrentLevel());

        permissionManager.setMCurrentLevel(PermissionLevel.USER);
        assertEquals(PermissionLevel.USER, permissionManager.getMCurrentLevel());
    }

}
