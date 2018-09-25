package com.company;

import javafx.util.Pair;

import java.util.*;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static int[][] copyMatrix(int[][] cube) {
        int[][] newCube = new int[9][12];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 12; j++) {
                newCube[i][j] = cube[i][j];
            }
        }
        return newCube;
    }

    static void printInColor(int box) {
        switch(box) {
            case 1:
                System.out.print(ANSI_WHITE + box + " " +  ANSI_RESET);
                break;
            case 2:
                System.out.print(ANSI_PURPLE + box + " " + ANSI_RESET);
                break;
            case 3:
                System.out.print(ANSI_GREEN + box + " " + ANSI_RESET);
                break;
            case 4:
                System.out.print(ANSI_RED + box + " " + ANSI_RESET);
                break;
            case 5:
                System.out.print(ANSI_BLUE + box + " " + ANSI_RESET);
                break;
            case 6:
                System.out.print(ANSI_YELLOW + box + " " + ANSI_RESET);
                break;
            default:
                System.out.print("  ");
                break;
        }
    }

    static void printCube(int[][] cube) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 12; j++) {
                if (cube[i][j] != 0) {
                    printInColor(cube[i][j]);
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static String matrixToString(int[][] cube) {
        String result = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 12; j++) {
                result += Integer.toString(cube[i][j]);
            }
        }
        return result;
    }

    static int[][] stringToMatrix(String cube) {
        int[][] result = new int[9][12];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 12; j++) {
                result[i][j] = Character.getNumericValue(cube.charAt(index));
                index++;
            }
        }
        return result;
    }

    static void rotateFrontClockwise(int[][] cube) {
        int temp30 = cube[3][0];
        int temp31 = cube[3][1];
        cube[3][0] = cube[5][0];
        cube[3][1] = cube[4][0];
        cube[5][0] = cube[5][2];
        cube[4][0] = cube[5][1];
        cube[5][2] = cube[3][2];
        cube[5][1] = cube[4][2];
        cube[3][2] = temp30;
        cube[4][2] = temp31;

        int temp33 = cube[3][3];
        int temp43 = cube[4][3];
        int temp53 = cube[5][3];
        cube[3][3] = cube[8][6];
        cube[4][3] = cube[8][7];
        cube[5][3] = cube[8][8];
        cube[8][6] = cube[5][11];
        cube[8][7] = cube[4][11];
        cube[8][8] = cube[3][11];
        cube[5][11] = cube[0][8];
        cube[4][11] = cube[0][7];
        cube[3][11] = cube[0][6];
        cube[0][8] = temp33;
        cube[0][7] = temp43;
        cube[0][6] = temp53;
    }

    static void rotateFrontCounterClockwise(int[][] cube) {
        int temp30 = cube[3][0];
        int temp31 = cube[3][1];
        cube[3][0] = cube[3][2];
        cube[3][1] = cube[4][2];
        cube[3][2] = cube[5][2];
        cube[4][2] = cube[5][1];
        cube[5][2] = cube[5][0];
        cube[5][1] = cube[4][0];
        cube[5][0] = temp30;
        cube[4][0] = temp31;


        int temp33 = cube[3][3];
        int temp43 = cube[4][3];
        int temp53 = cube[5][3];
        cube[3][3] = cube[0][8];
        cube[4][3] = cube[0][7];
        cube[5][3] = cube[0][6];
        cube[0][8] = cube[5][11];
        cube[0][7] = cube[4][11];
        cube[0][6] = cube[3][11];
        cube[5][11] = cube[8][6];
        cube[4][11] = cube[8][7];
        cube[3][11] = cube[8][8];
        cube[8][6] = temp33;
        cube[8][7] = temp43;
        cube[8][8] = temp53;
    }

    static void rotateBackClockwise(int[][] cube) {
        int temp36 = cube[3][6];
        int temp37 = cube[3][7];
        cube[3][6] = cube[5][6];
        cube[3][7] = cube[4][6];
        cube[5][6] = cube[5][8];
        cube[4][6] = cube[5][7];
        cube[5][8] = cube[3][8];
        cube[5][7] = cube[4][8];
        cube[3][8] = temp36;
        cube[4][8] = temp37;

        int temp35 = cube[3][5];
        int temp45 = cube[4][5];
        int temp55 = cube[5][5];
        cube[3][5] = cube[6][6];
        cube[4][5] = cube[6][7];
        cube[5][5] = cube[6][8];
        cube[6][6] = cube[5][9];
        cube[6][7] = cube[4][9];
        cube[6][8] = cube[3][9];
        cube[5][9] = cube[2][8];
        cube[4][9] = cube[2][7];
        cube[3][9] = cube[2][6];
        cube[2][8] = temp35;
        cube[2][7] = temp45;
        cube[2][6] = temp55;
    }

    static void rotateBackCounterClockwise(int[][] cube) {
        int temp36 = cube[3][6];
        int temp37 = cube[3][7];
        cube[3][6] = cube[3][8];
        cube[3][7] = cube[4][8];
        cube[3][8] = cube[5][8];
        cube[4][8] = cube[5][7];
        cube[5][8] = cube[5][6];
        cube[5][7] = cube[4][6];
        cube[5][6] = temp36;
        cube[4][6] = temp37;

        int temp35 = cube[3][5];
        int temp45 = cube[4][5];
        int temp55 = cube[5][5];
        cube[3][5] = cube[2][8];
        cube[4][5] = cube[2][7];
        cube[5][5] = cube[2][6];
        cube[2][8] = cube[5][9];
        cube[2][7] = cube[4][9];
        cube[2][6] = cube[3][9];
        cube[5][9] = cube[6][6];
        cube[4][9] = cube[6][7];
        cube[3][9] = cube[6][8];
        cube[6][6] = temp35;
        cube[6][7] = temp45;
        cube[6][8] = temp55;

    }

    static void rotateLeftClockwise(int[][] cube) {
        int temp1 = cube[3][0];
        int temp2 = cube[4][0];
        int temp3 = cube[5][0];
        cube[3][0] = cube[2][8];
        cube[4][0] = cube[1][8];
        cube[5][0] = cube[0][8];
        cube[2][8] = cube[5][8];
        cube[1][8] = cube[4][8];
        cube[0][8] = cube[3][8];
        cube[5][8] = cube[8][8];
        cube[4][8] = cube[7][8];
        cube[3][8] = cube[6][8];
        cube[8][8] = temp1;
        cube[7][8] = temp2;
        cube[6][8] = temp3;

        temp1 = cube[3][9];
        temp2 = cube[4][9];
        cube[3][9] = cube[5][9];
        cube[4][9] = cube[5][10];
        cube[5][9] = cube[5][11];
        cube[5][10] = cube[4][11];
        cube[5][11] = cube[3][11];
        cube[4][11] = cube[3][10];
        cube[3][11] = temp1;
        cube[3][10] = temp2;
    }

    static void rotateLeftCounterClockwise(int[][] cube) {
        int temp1 = cube[3][0];
        int temp2 = cube[4][0];
        int temp3 = cube[5][0];
        cube[3][0] = cube[8][8];
        cube[4][0] = cube[7][8];
        cube[5][0] = cube[6][8];
        cube[8][8] = cube[5][8];
        cube[7][8] = cube[4][8];
        cube[6][8] = cube[3][8];
        cube[5][8] = cube[2][8];
        cube[4][8] = cube[1][8];
        cube[3][8] = cube[0][8];
        cube[2][8] = temp1;
        cube[1][8] = temp2;
        cube[0][8] = temp3;

        temp1 = cube[3][9];
        temp2 = cube[4][9];
        cube[3][9] = cube[3][11];
        cube[4][9] = cube[3][10];
        cube[3][11] = cube[5][11];
        cube[3][10] = cube[4][11];
        cube[5][11] = cube[5][9];
        cube[4][11] = cube[5][10];
        cube[5][9] = temp1;
        cube[5][10] = temp2;
    }

    static void rotateRightClockwise(int[][] cube) {
        int temp33 = cube[3][3];
        int temp34 = cube[3][4];
        cube[3][3] = cube[5][3];
        cube[3][4] = cube[4][3];
        cube[5][3] = cube[5][5];
        cube[4][3] = cube[5][4];
        cube[5][5] = cube[3][5];
        cube[5][4] = cube[4][5];
        cube[3][5] = temp33;
        cube[4][5] = temp34;

        int temp36 = cube[3][6];
        int temp46 = cube[4][6];
        int temp56 = cube[5][6];
        cube[3][6] = cube[0][6];
        cube[4][6] = cube[1][6];
        cube[5][6] = cube[2][6];
        cube[0][6] = cube[5][2];
        cube[1][6] = cube[4][2];
        cube[2][6] = cube[3][2];
        cube[5][2] = cube[6][6];
        cube[4][2] = cube[7][6];
        cube[3][2] = cube[8][6];
        cube[6][6] = temp36;
        cube[7][6] = temp46;
        cube[8][6] = temp56;
    }

    static void rotateRightCounterClockwise(int[][] cube) {
        int temp33 = cube[3][3];
        int temp34 = cube[3][4];
        cube[3][3] = cube[3][5];
        cube[3][4] = cube[4][5];
        cube[3][5] = cube[5][5];
        cube[4][5] = cube[5][4];
        cube[5][5] = cube[5][3];
        cube[5][4] = cube[4][3];
        cube[5][3] = temp33;
        cube[4][3] = temp34;

        int temp36 = cube[3][6];
        int temp46 = cube[4][6];
        int temp56 = cube[5][6];
        cube[3][6] = cube[6][6];
        cube[4][6] = cube[7][6];
        cube[5][6] = cube[8][6];
        cube[6][6] = cube[5][2];
        cube[7][6] = cube[4][2];
        cube[8][6] = cube[3][2];
        cube[5][2] = cube[0][6];
        cube[4][2] = cube[1][6];
        cube[3][2] = cube[2][6];
        cube[0][6] = temp36;
        cube[1][6] = temp46;
        cube[2][6] = temp56;
    }

    static void rotateTopClockwise(int[][] cube) {
        int temp06 = cube[0][6];
        int temp07 = cube[0][7];
        cube[0][6] = cube[2][6];
        cube[0][7] = cube[1][6];
        cube[2][6] = cube[2][8];
        cube[1][6] = cube[2][7];
        cube[2][8] = cube[0][8];
        cube[2][7] = cube[1][8];
        cube[0][8] = temp06;
        cube[1][8] = temp07;

        int temp36 = cube[3][6];
        int temp37 = cube[3][7];
        int temp38 = cube[3][8];
        cube[3][6] = cube[3][9];
        cube[3][7] = cube[3][10];
        cube[3][8] = cube[3][11];
        cube[3][9] = cube[3][0];
        cube[3][10] = cube[3][1];
        cube[3][11] = cube[3][2];
        cube[3][0] = cube[3][3];
        cube[3][1] = cube[3][4];
        cube[3][2] = cube[3][5];
        cube[3][3] = temp36;
        cube[3][4] = temp37;
        cube[3][5] = temp38;
    }

    static void rotateTopCounterClockwise(int[][] cube) {
        int temp06 = cube[0][6];
        int temp07 = cube[0][7];
        cube[0][6] = cube[0][8];
        cube[0][7] = cube[1][8];
        cube[0][8] = cube[2][8];
        cube[1][8] = cube[2][7];
        cube[2][8] = cube[2][6];
        cube[2][7] = cube[1][6];
        cube[2][6] = temp06;
        cube[1][6] = temp07;

        int temp36 = cube[3][6];
        int temp37 = cube[3][7];
        int temp38 = cube[3][8];
        cube[3][6] = cube[3][3];
        cube[3][7] = cube[3][4];
        cube[3][8] = cube[3][5];
        cube[3][3] = cube[3][0];
        cube[3][4] = cube[3][1];
        cube[3][5] = cube[3][2];
        cube[3][0] = cube[3][9];
        cube[3][1] = cube[3][10];
        cube[3][2] = cube[3][11];
        cube[3][9] = temp36;
        cube[3][10] = temp37;
        cube[3][11] = temp38;
    }

    static void rotateBottomClockwise(int[][] cube) {
        int temp66 = cube[6][6];
        int temp67 = cube[6][7];
        cube[6][6] = cube[8][6];
        cube[6][7] = cube[7][6];
        cube[8][6] = cube[8][8];
        cube[7][6] = cube[8][7];
        cube[8][8] = cube[6][8];
        cube[8][7] = cube[7][8];
        cube[6][8] = temp66;
        cube[7][8] = temp67;

        int temp56 = cube[5][6];
        int temp57 = cube[5][7];
        int temp58 = cube[5][8];
        cube[5][6] = cube[5][3];
        cube[5][7] = cube[5][4];
        cube[5][8] = cube[5][5];
        cube[5][3] = cube[5][0];
        cube[5][4] = cube[5][1];
        cube[5][5] = cube[5][2];
        cube[5][0] = cube[5][9];
        cube[5][1] = cube[5][10];
        cube[5][2] = cube[5][11];
        cube[5][9] = temp56;
        cube[5][10] = temp57;
        cube[5][11] = temp58;
    }

    static void rotateBottomCounterClockwise(int[][] cube) {
        int temp66 = cube[6][6];
        int temp67 = cube[6][7];
        cube[6][6] = cube[6][8];
        cube[6][7] = cube[7][8];
        cube[6][8] = cube[8][8];
        cube[7][8] = cube[8][7];
        cube[8][8] = cube[8][6];
        cube[8][7] = cube[7][6];
        cube[8][6] = temp66;
        cube[7][6] = temp67;

        int temp56 = cube[5][6];
        int temp57 = cube[5][7];
        int temp58 = cube[5][8];
        cube[5][6] = cube[5][9];
        cube[5][7] = cube[5][10];
        cube[5][8] = cube[5][11];
        cube[5][9] = cube[5][0];
        cube[5][10] = cube[5][1];
        cube[5][11] = cube[5][2];
        cube[5][0] = cube[5][3];
        cube[5][1] = cube[5][4];
        cube[5][2] = cube[5][5];
        cube[5][3] = temp56;
        cube[5][4] = temp57;
        cube[5][5] = temp58;
    }

    static List<String> getAppliableRules() {
        List<String> appliableRules = new ArrayList<>();
        appliableRules.add("frontCW");
        appliableRules.add("frontCounterCW");
        appliableRules.add("backCW");
        appliableRules.add("backCounterCW");
        appliableRules.add("leftCW");
        appliableRules.add("leftCounterCW");
        appliableRules.add("rightCW");
        appliableRules.add("rightCounterCW");
        appliableRules.add("topCW");
        appliableRules.add("topCounterCW");
        appliableRules.add("bottomCW");
        appliableRules.add("bottomCounterCW");
        return appliableRules;
    }

    static void applyRule(int[][] cube, String rule) {
        switch (rule) {
            case "frontCW":
                rotateFrontClockwise(cube);
                break;
            case "frontCounterCW":
                rotateFrontCounterClockwise(cube);
                break;
            case "backCW":
                rotateBackClockwise(cube);
                break;
            case "backCounterCW":
                rotateBackCounterClockwise(cube);
                break;
            case "leftCW":
                rotateLeftClockwise(cube);
                break;
            case "leftCounterCW":
                rotateLeftCounterClockwise(cube);
                break;
            case "rightCW":
                rotateRightClockwise(cube);
                break;
            case "rightCounterCW":
                rotateRightCounterClockwise(cube);
                break;
            case "topCW":
                rotateTopClockwise(cube);
                break;
            case "topCounterCW":
                rotateTopCounterClockwise(cube);
                break;
            case "bottomCW":
                rotateBottomClockwise(cube);
                break;
            case "bottomCounterCW":
                rotateBottomCounterClockwise(cube);
                break;
        }
    }

    static boolean isAncestor(HashMap<String, Pair<String, Float>> graph, String possibleAncestor, String currentState) {
        String tempState = currentState;
        boolean response = false;
        while (!tempState.equals("")) {
            tempState = graph.get(tempState).getKey();
            if (tempState.equals(possibleAncestor)) {
                response = true;
                break;
            }
        }
        return response;
    }

    static float gFunction(String currentState, String initialState, HashMap<String, Pair<String, Float>> graph) {
        float cost = 0;
        String tempState = currentState;
        while (!tempState.equals(initialState)) {
            cost += graph.get(tempState).getValue();
            tempState = graph.get(tempState).getKey();
        }
        return cost;
    }


    static float hFunction(String currentState, String finalState, HashMap<String, Pair<String, Float>> graph) {
        float cost = 0;
        for (int i = 0; i < 9 * 12; i++) {
            if (currentState.charAt(i) != finalState.charAt(i)) {
                cost++;
            }
        }
        return cost;
    }

    static float getCostOfRule(String rule) {
        return 3;
    }

    static void printPath(HashMap<String, Pair<String, Float>> graph, String finalState) {
        Stack<String> statesPath = new Stack<>();
        System.out.println("estados visitados: " + graph.size());
        String currentState = finalState;
        float totalCost = 0;
        while (!currentState.equals("")) {
            statesPath.add(currentState);
            totalCost += graph.get(currentState).getValue();
            currentState = graph.get(currentState).getKey();
        }
        int counter = 1;
        while (!statesPath.isEmpty()) {
            System.out.println("Iteracion " + counter);
            String state = statesPath.pop();
            printCube(stringToMatrix(state));
            counter++;
        }
        System.out.println("total cost: " + totalCost);
    }

    static boolean isFinalState(String state, String finalState) {
        int[][] mat = stringToMatrix(state);
        boolean response = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {

            }
        }
        return response;
    }

    static boolean aAlgorithm(String initialState, String finalState, HashMap<String, Pair<String, Float>> graph) {
        graph.put(initialState, new Pair<>("", (float) 0));
        OpenedStates open = new OpenedStates();
        HashSet<String> closed = new HashSet<>();
        open.insert(0, initialState);
        boolean found = false;
        Pair<String, Float> currentState;
        while (!open.isEmpty() && !found) {
            currentState = open.popMinValue();
            closed.add(currentState.getKey());
            if (currentState.getKey().equals(finalState)) {
                found = true;
                System.out.println("deberia ser lo mismo que est vis");
                System.out.println(open.getLength() + closed.size());
                System.out.println("cerrados (expandidos)");
                System.out.println(closed.size());
                printPath(graph, finalState);
            }
            else {
                List<String> appliableRules = getAppliableRules();
                while (!appliableRules.isEmpty()) {
                    String rule = appliableRules.remove(0);
                    int[][] genState = stringToMatrix(currentState.getKey());
                    applyRule(genState, rule);
                    String generatedState = matrixToString(genState);
                    float gValue, fValue;
                    if (!isAncestor(graph, generatedState, currentState.getKey())) {
                        float tempCost = gFunction(currentState.getKey(), initialState, graph) +
                                getCostOfRule(rule);
                        if (!open.contains(generatedState) && !closed.contains(generatedState)) {
                            gValue = tempCost;
                            fValue = gValue + hFunction(generatedState, finalState, graph);
                            graph.put(generatedState, new Pair<>(currentState.getKey(), getCostOfRule(rule)));
                            open.insert(fValue, generatedState);
                        }
                        else {
                            if (tempCost < gFunction(generatedState, initialState, graph)) {
                                gValue = tempCost;
                                fValue = gValue + hFunction(generatedState, finalState, graph);
                                graph.put(generatedState, new Pair<>(currentState.getKey(), getCostOfRule(rule)));
                                if (open.contains(generatedState)) {
                                    open.update(generatedState, fValue);
                                }
                                if (closed.contains(generatedState)) {
                                    closed.remove(generatedState);
                                    open.insert(fValue, generatedState);
                                }
                            }
                        }
                    }
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[][] initialState = new int[9][12];
        int[][] finalState = new int[9][12];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 12; j++) {
                initialState[i][j] = 0;
                finalState[i][j] = 0;
            }
        }
        //1 = blanco
        //2 = naranja
        //3 = verde
        // 4 = rojo
        // 5 = azul
        // 6 = amarillo

        finalState[0][6] = 1;
        finalState[0][7] = 1;
        finalState[0][8] = 1;
        finalState[1][6] = 1;
        finalState[1][7] = 1;
        finalState[1][8] = 1;
        finalState[2][6] = 1;
        finalState[2][7] = 1;
        finalState[2][8] = 1;

        finalState[3][0] = 2;
        finalState[3][1] = 2;
        finalState[3][2] = 2;
        finalState[3][3] = 3;
        finalState[3][4] = 3;
        finalState[3][5] = 3;
        finalState[3][6] = 4;
        finalState[3][7] = 4;
        finalState[3][8] = 4;
        finalState[3][9] = 5;
        finalState[3][10] = 5;
        finalState[3][11] = 5;
        finalState[4][0] = 2;
        finalState[4][1] = 2;
        finalState[4][2] = 2;
        finalState[4][3] = 3;
        finalState[4][4] = 3;
        finalState[4][5] = 3;
        finalState[4][6] = 4;
        finalState[4][7] = 4;
        finalState[4][8] = 4;
        finalState[4][9] = 5;
        finalState[4][10] = 5;
        finalState[4][11] = 5;
        finalState[5][0] = 2;
        finalState[5][1] = 2;
        finalState[5][2] = 2;
        finalState[5][3] = 3;
        finalState[5][4] = 3;
        finalState[5][5] = 3;
        finalState[5][6] = 4;
        finalState[5][7] = 4;
        finalState[5][8] = 4;
        finalState[5][9] = 5;
        finalState[5][10] = 5;
        finalState[5][11] = 5;

        finalState[6][6] = 6;
        finalState[6][7] = 6;
        finalState[6][8] = 6;
        finalState[7][6] = 6;
        finalState[7][7] = 6;
        finalState[7][8] = 6;
        finalState[8][6] = 6;
        finalState[8][7] = 6;
        finalState[8][8] = 6;

        initialState = copyMatrix(finalState);

        rotateFrontClockwise(initialState);
        rotateTopClockwise(initialState);
        rotateLeftClockwise(initialState);
        rotateBottomCounterClockwise(initialState);
        rotateRightClockwise(initialState);
        rotateBackCounterClockwise(initialState);
        rotateTopCounterClockwise(initialState);
        rotateFrontCounterClockwise(initialState);
        rotateRightCounterClockwise(initialState);

        String initialString = matrixToString(initialState);
        String finalString = matrixToString(finalState);
        HashMap<String, Pair<String, Float>> graph = new HashMap<>();
        System.out.println(aAlgorithm(initialString, finalString, graph));
    }
}
