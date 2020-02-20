---
description: >-
  Cette page est à lire impérativement avant d'utiliser l'API proposé
  d'UlityCore
---

# Commencement

## Initialiser l'API au tout début

Vous devez initialiser l'API avant même de charger les class de l'API. Les constructeurs de ces class ne doivent pas être exécutes avant l'initialisation de l'API sous peine d'erreur de pointeur.

### Bukkit

```java
package X.bukkit;

import fr.ulity.core.api.Api;

public class mainX extends JavaPlugin {

    public static Config config /*= new Config()*/;
    // ne pas charler les class avant l'initialisation

    @Override
    public void onEnable(){
        Api.initialize(this);
        // l'API est maintenant initialisée
        
        config = new Config();
        // nous pouvons maintenant utiliser l'API
        // comme bon nous semble
        
    }

}
```

{% hint style="info" %}
la pratique est similaire pour un plugin sous Bungeecord
{% endhint %}

### BungeeCord

```java
package X.bungee;

public class mainX extends Plugin {

    public static Config config /*= new Config()*/;
    // ne pas charler les class avant l'initialisation
    
    @Override
    public void onEnable() {
        Api.initialize(this);
        // l'API est maintenant initialisée
    
        config = new Config();
        // nous pouvons maintenant utiliser l'API
        // comme bon nous semble
    
    }


}
```



