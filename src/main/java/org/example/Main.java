package org.example;

public class Main {
    public static void main(String[] args) {

        PermissionManager permissionManager = new PermissionManager();
        System.out.println("Default: " + permissionManager.getMCurrentLevel());

        permissionManager.setMCurrentLevel(PermissionLevel.ADMIN);
        System.out.println("After escalation: " + permissionManager.getMCurrentLevel());
    }
}