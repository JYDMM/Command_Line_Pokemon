public class Type {
    public static double Effectiveness(Move moveUsed, Pokemon beingAttacked) {
        // Setting up effectiveness array
        // 1 = Half damage    2 = standard damage
        // 4 = Double damage  8 = no damage
        byte effective[][] = new byte[16][16];
        byte bugEffective[]      = {2,4,2,2,1,1,1,1,4,2,2,2,1,4,2,2};
        byte darkEffective[]     = {2,1,2,2,1,2,2,4,2,2,2,2,2,4,2,2};
        byte dragonEffective[]   = {2,2,4,2,2,2,2,2,2,2,2,2,2,2,2,2};
        byte electricEffective[] = {2,2,1,1,2,2,4,2,1,8,2,2,2,2,2,4};
        byte fightingEffective[] = {1,4,2,2,2,2,1,8,2,2,4,4,1,1,4,2};
        byte fireEffective[]     = {4,2,1,2,2,1,2,2,4,2,4,2,2,2,1,1};
        byte flyingEffective[]   = {4,2,2,1,4,2,2,2,4,2,2,2,2,2,1,2};
        byte ghostEffective[]    = {2,1,2,2,2,2,2,4,2,2,2,8,2,4,2,2};
        byte grassEffective[]    = {1,2,1,2,2,1,1,2,1,4,2,2,1,2,4,4};
        byte groundEffective[]   = {1,2,2,4,2,4,8,2,1,2,2,2,4,2,4,2};
        byte iceEffective[]      = {2,2,4,2,2,1,4,2,2,2,1,2,2,2,2,1};
        byte normalEffective[]   = {2,2,2,2,2,2,2,8,2,2,2,2,2,2,1,2};
        byte poisonEffective[]   = {2,2,2,2,2,2,2,1,4,1,2,2,1,2,1,2};
        byte psychicEffective[]  = {2,8,2,2,4,2,2,2,2,2,2,2,4,1,2,2};
        byte rockEffective[]     = {4,2,2,2,1,4,4,2,2,1,4,2,2,2,2,2};
        byte waterEffective[]    = {2,2,1,2,2,4,2,2,1,4,2,2,2,2,4,1};

        // this basically just combines the arrays above into one multiline array
        for (int i = 0; i <= 15; i++) {
            effective[0][i] = bugEffective[i];
            effective[1][i] = darkEffective[i];
            effective[2][i] = dragonEffective[i];
            effective[3][i] = electricEffective[i];
            effective[4][i] = fightingEffective[i];
            effective[5][i] = fireEffective[i];
            effective[6][i] = flyingEffective[i];
            effective[7][i] = ghostEffective[i];
            effective[8][i] = grassEffective[i];
            effective[9][i] = groundEffective[i];
            effective[10][i] = iceEffective[i];
            effective[11][i] = normalEffective[i];
            effective[12][i] = poisonEffective[i];
            effective[13][i] = psychicEffective[i];
            effective[14][i] = rockEffective[i];
            effective[15][i] = waterEffective[i];
        }


        if (effective[moveUsed.Type()][beingAttacked.Type()] == 1) {
            return 0.5;
        } else if (effective[moveUsed.Type()][beingAttacked.Type()] == 2) {
            return 1;
        } else if (effective[moveUsed.Type()][beingAttacked.Type()] == 4) {
            return 2;
        } else if (effective[moveUsed.Type()][beingAttacked.Type()] == 8) {
            return 0;
        } else {
            return 8;
        }
    }
}
