package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).sorted(Comparator.comparing(method -> method.getName().length()))
        .forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).map(method -> method.getName()).distinct()
        .sorted().forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() >= 2 && Arrays.stream(method.getParameterTypes()).distinct().count() == 1)
                .sorted(Comparator.comparing(method -> method.getName()))
        .forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).map(method -> method.getReturnType())
                .distinct().sorted(Comparator.comparing(method -> method.getTypeName()))
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(method -> Arrays.stream(method.getParameterTypes())
                .anyMatch(param -> param.getName().equals("boolean")))
                .sorted(Comparator.comparing(method -> method.getName())).forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .filter(method -> Arrays.stream(method.getParameterTypes()).anyMatch(param -> param.getName().equals("int")))
                .filter(method -> Arrays.stream(method.getParameterTypes()).distinct().count() == 1)
                .sorted(Comparator.comparing(method -> method.getName())).forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).max(Comparator.comparing(method -> method.getName().length()))
                .map(method -> method.getName()).get();
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(method -> method.getModifiers() == Modifier.PUBLIC)
                .max(Comparator.comparing(method -> method.getName())).map(method -> method.getName()).get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .mapToInt(method -> method.getParameterCount()).summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .mapToInt(method -> method.getParameterCount()).max().getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .max(Comparator.comparingInt(method -> method.getParameterCount())).get();
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Arrays.stream(String.class.getDeclaredMethods())
                .flatMap(method -> Arrays.stream(method.getParameterTypes()).map(parameterType -> parameterType.getName()))
                .distinct().sorted().forEach(System.out::println);
    }

}
