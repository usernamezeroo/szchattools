package com.tamil.szchattools.sample.common.data.fixtures;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.UUID;

/*
 * Created by sz
 */
abstract class FixturesData {

    static SecureRandom rnd = new SecureRandom();

    static ArrayList<String> avatars = new ArrayList<String>() {
        {
            add("https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745");
            add("https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745");
            add("https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745");
            add("https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745");
        }
    };

    static final ArrayList<String> groupChatImages = new ArrayList<String>() {
        {
            add("https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745");
            add("https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745");
            add("https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745");
        }
    };

    static final ArrayList<String> groupChatTitles = new ArrayList<String>() {
        {
            add("ramesh, kumar");
            add("vetri, vel, kalai");
            add("muthu, raja, roja, nela");
        }
    };

    static final ArrayList<String> names = new ArrayList<String>() {
        {
            add("vetrivel ");
            add("kalai arasu");
            add("mahi mahi");
            add("tamil selvan");
            add("muthu vel");
            add("kali muthu");
            add("vijay raja");
            add("sami nathan");
            add("rajini kamal");
            add("suriya ajith");
            add("samantha nayan");
        }
    };

    static final ArrayList<String> messages = new ArrayList<String>() {
        {
            add("Hello!");
            add("This is my phone number - +1 (234) 567-89-01");
            add("Here is my e-mail - myemail@example.com");
            add("Hey! Check out this awesome link! www.github.com");
            add("Hello! No problem. I can today at 2 pm. And after we can go to the office.");
            add("At first, for some time, I was not able to answer him one word");
            add("At length one of them called out in a clear, polite, smooth dialect, not unlike in sound to the Italian");
            add("By the bye, Bob, said Hopkins");
            add("He made his passenger captain of one, with four of the men; and himself, his mate, and five more, went in the other; and they contrived their business very well, for they came up to the ship about midnight.");
            add("So saying he unbuckled his baldric with the bugle");
            add("Just then her head struck against the roof of the hall: in fact she was now more than nine feet high, and she at once took up the little golden key and hurried off to the garden door.");
        }
    };

    static final ArrayList<String> images = new ArrayList<String>() {
        {
            add("https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745");
            add("https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745");
        }
    };

    static String getRandomId() {
        return Long.toString(UUID.randomUUID().getLeastSignificantBits());
    }

    static String getRandomAvatar() {
        return avatars.get(rnd.nextInt(avatars.size()));
    }

    static String getRandomGroupChatImage() {
        return groupChatImages.get(rnd.nextInt(groupChatImages.size()));
    }

    static String getRandomGroupChatTitle() {
        return groupChatTitles.get(rnd.nextInt(groupChatTitles.size()));
    }

    static String getRandomName() {
        return names.get(rnd.nextInt(names.size()));
    }

    static String getRandomMessage() {
        return messages.get(rnd.nextInt(messages.size()));
    }

    static String getRandomImage() {
        return images.get(rnd.nextInt(images.size()));
    }

    static boolean getRandomBoolean() {
        return rnd.nextBoolean();
    }
}
