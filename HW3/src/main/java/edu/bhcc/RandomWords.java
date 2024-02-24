
package edu.bhcc;

import java.util.Random;

/**
 * @Author : Matthew Dobler",
 * @Date : 2/22/24",
 * @File : RandomWords",
 * Class   : CSC-242",
 */
public class RandomWords implements Runnable{
    private int numRepeat;
    private String prefix;
    private String[] words ={"Apple", "Banana", "Pickle", "Sausage",
                            "Potato", "Tomato", "Fish", "Chicken",
                            "Beef", "Marshmallow"};

    public RandomWords(int numRepeat, String prefix)
    {
        this.numRepeat = numRepeat;
        this.prefix = prefix;
    }

    @Override
    public void run() {

        Random rand = new Random();
        for(int i = 0; i < numRepeat; i++)
        {
            System.out.println(prefix + "_" + words[rand.nextInt(words.length)]);
        }
    }
}
