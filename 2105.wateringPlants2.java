class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int i = 0, j = n - 1;

        int refill = 0;
        int ca = capacityA;
        int cb = capacityB;
        while (i <= j) {
            if (i == j) {
                if (ca < plants[i] && cb < plants[i]) {
                    // if i & j are same, if ith plant cannot be watered by ca & cb,
                    // then we need one more refill so return refill+1
                    return refill + 1;
                } else {
                    // means we can water from either ca & cb
                    // so refill is enough
                    return refill;
                }
            }
            if (ca >= plants[i]) {
                // if ca can water ith plant, then water it and remove water from ca
                ca -= plants[i];
            } else {
                // ca do not have enough water, so fill it and then remove water from ca.
                // also increment refill
                ca = capacityA;
                ca -= plants[i];
                refill++;
            }

            if (cb >= plants[j]) {
                // if cb can water jth plant, then water it and remove water from cb
                cb -= plants[j];
            } else {
                // cb do not have enough water, so fill it and then remove water from cb.
                // also increment refill
                cb = capacityB;
                cb -= plants[j];
                refill++;
            }
            i++;
            j--;
        }

        return refill;
    }
}