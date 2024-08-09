# EconomyAPI
Core of economy system for Nukkit

## Commands
 - /mymoney
 - /seemoney
 - /givemoney
 - /takemoney
 - /topmoney
 - /setmoney
 - /setlang

## Permissions
- economyapi
	- economyapi.command
		- economyapi.command.mymoney
		- economyapi.command.givemoney `OP`
		- economyapi.command.takemoney `OP`
		- economyapi.command.setmoney `OP`
		- economyapi.command.topmoney
  		- economyapi.command.setlang `OP`

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
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
</repository>

<dependency>
	<groupId>com.github.wuliao697</groupId>
	<artifactId>EconomyAPI-PNX</artifactId>
	<version>Tag</version>
</dependency>
```
