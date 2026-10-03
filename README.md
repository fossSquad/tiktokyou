## tiktokyou (reversed)
i decompile and made (almost) readable code and also made it compilable :)

made in 2 days w/deepseek v4.1 flash & gemini 3.8 flash

### guide
0. if you wanna update tiktokyou sources, run `./gradlew extract TikTok_You*.apk`
1. download vanilla tiktok apk from apkmirror/apkpure.. _(if TikTok You apk you downloaded based on 46.8.3, download 46.8.3 (arm7+arm8 ver!!!))_
2. run `./gradlew genLib com.zhiliaoapp.musically*.apk`, it'll generate `tiktok.jar` in lib dir
3. run `./gradlew supportJar TikTok_You*.apk` to compile hook lib from proprietary shi _(theyre in src but has tons of decompile artifacts and no one will make it compilable because why??)_
4. run `./gradlew buildDex` it'll build mod, output will be in `build/mod`
5. and finally run `./gradlew patch com.zhiliaoapp.musically*.apk` to patch vanilla tiktok

### note about srcs
some things like mod core impossible full restore original code structure.. you can restore it but it'll be unofficial names and mismatch original code structure that tty devs has..

also im not proffesional reverser that knows everything, so i asked ai to reverse it

and this repo lowk made for code skid/paste, explore etc., not for forks yknow