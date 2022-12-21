package config;

import org.aeonbits.owner.Config;


    @Config.LoadPolicy(Config.LoadType.MERGE)
    @Config.Sources({
            "system:properties",
            "classpath:config/properties"
    })

    public interface ProjectConfig extends Config {
        @Config.DefaultValue("chrome")
        @Config.Key("browser")
        String browser();

        @Config.DefaultValue("100.0")
        @Config.Key("browserVersion")
        String browserVersion();

        @Config.DefaultValue("1920x1080")
        @Config.Key("browserSize")
        String browserSize();

//        @Config.DefaultValue("")
//        @Config.Key("remoteDriverUrl")
//        String remoteDriverUrl();

        @Config.DefaultValue("https://github.com/")
        @Config.Key("baseUrl")
        String baseUrl();
    }

