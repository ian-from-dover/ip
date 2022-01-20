// import java.io.*;
import java.util.Scanner;

public class Lily {
    public static void main(String[] args) {
        // IO
        Scanner sc = new Scanner(System.in);
        // Characterisation from: https://www.springhole.net/writing/writing-lovable-jerks.htm
        // and from https://www.springhole.net/writing/ways-to-fill-out-and-humanize-your-character.htm
        // and quality control from https://www.springhole.net/writing/character-playability-test.htm
        /**
         * Lily's reason for being here: her part time job. school sucks but not as bad as home or here.
         * oh, hold on a sec, someone else is asking me for a coffee or soemthing
         *
         * tension with parents - holes up in room when she gets back. has to hold back what she wants to say in order
         * cuz she doesn't think they care about her, or want to know her.
         * ignores about being the most attractive person
         * doesn't really want to help you, i can't be doing all the heavy lifting, right?
         * have irritating users. and some who are just mean or spiteful
         *
         * make her a hero: personal sacrifice to help you, or take risk and prevail
         * she won't take social initiative
         * one good thing lily helped someone else with
         * one thing lily feels good about herself
         * embarrassing thing lily did in the past
         * someone intro her to fun adventures but she doesn't want to go, went anyway
         *
         * would never intro her father to her friends, cuz he'd say something insensitive
         * put real, strenuous and even frustrating effort into getting the important stuff done. setbacks and snags along the way
         * looked unkempt and mussed up for boring reasons
         * character's emotions
         *
         * attached to a personal object
         */
        System.out.println("▼＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝▼");
        String logo = "\n" +
                "██╗     ██╗██╗     ██╗   ██╗\n" +
                "██║     ██║██║     ╚██╗ ██╔╝\n" +
                "██║     ██║██║      ╚████╔╝ \n" +
                "██║     ██║██║       ╚██╔╝  \n" +
                "███████╗██║███████╗   ██║   \n" +
                "╚══════╝╚═╝╚══════╝   ╚═╝   \n" +
                "                            ";
        System.out.println(logo);
        System.out.println("Hey.\n" +
                "Need help with something?\n");
        System.out.println("Commands you can type");
        System.out.println("> echo: say what you type with ECHO");
        System.out.println("> exit: stop talking with Lily");
        System.out.println("▼＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝▼\n");

        // case statements
        String action = sc.next();
        if (action == "bye") {
            System.out.println("▼＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝▼");
            System.out.println("see ya.");
            System.out.println("▼＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝▼\n");
        } else {
            System.out.println("▼＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝▼");
            System.out.println("you didn't type bye");
            System.out.println("▼＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝▼\n");
        }
        sc.close();
    }
}
