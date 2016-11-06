/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.oxlemonxo.supernova.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EightBallUtil
{

    public static final String[] yes =
    {
        "It is certain", "It is decidedly so", "Without a doubt", "Yes definitely", "You may rely on it", "As I see it yes", "Most likely", "Outlook good", "Yes", "Signs point to yes"
    };
    public static final String[] neutral =
    {
        "Reply hazy try again", "Ask again later", "Better not tell you now", "Cannot predict now", "Concentrate and ask again"
    };

    public static final String[] no = 
    {
        "Don't count on it", "My reply is no", "My sources say no", "My sources say no", "Very doubtful"
    };
    public static String getYesString()
    {
        Random random = new Random();
        int select = random.nextInt(yes.length);
        return yes[select];
    }

    public static String getNeutralString()
    {
        Random random = new Random();
        int select = random.nextInt(neutral.length);
        return neutral[select];
    }

    public static String getNoString()
    {
        Random random = new Random();
        int select = random.nextInt(no.length);
        return no[select];
    }
}
