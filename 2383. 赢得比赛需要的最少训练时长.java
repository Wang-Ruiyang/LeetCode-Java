class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int energy_all = 1;
        int experience_all = initialExperience;
        int experience_ex = 0;
        int n = energy.length;
        for (int i=0;i<n;i++) {
            energy_all += energy[i];
            if(experience_all>experience[i]) {
                experience_all += experience[i];
            }
            else {
                experience_ex += experience[i] - experience_all + 1;
                experience_all = experience[i]*2 + 1;
            }
        }
        int time = 0;
        if ((energy_all - initialEnergy) > 0) {
            time += energy_all - initialEnergy;
        }
        time += experience_ex;
        return time;
    }
}