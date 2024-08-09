# EconomyAPI
Core of economy system for Nukkit

## Commands
 - /mymoney
 - /seemoney
 - /givemoney
 - /takemoney
 - /topmoney
 - /setmoney

## Permissions
- economyapi
	- economyapi.command
		- economyapi.command.mymoney
		- economyapi.command.givemoney `OP`
		- economyapi.command.takemoney `OP`
		- economyapi.command.setmoney `OP`
		- economyapi.command.topmoney

## For developers

Developers can access to EconomyAPI's API by using:
```java
EconomyAPI.getInstance().myMoney(player);
EconomyAPI.getInstance().reduceMoney(player, amount);
EconomyAPI.getInstance().addMoney(player, amount);
```

### Maven repository
```xml
<repository>
    <id>nukkitx-repo</id>
    <url>https://repo.nukkitx.com/snapshot</url>
</repository>

<dependency>
    <groupId>me.onebone</groupId>
    <artifactId>economyapi</artifactId>
    <version>2.0.2</version>
    <scope>provided</scope>
</dependency>
```
