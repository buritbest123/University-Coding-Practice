class Ironman extends SuperHero implements SkillHero,Nation{

    public void skill(String skill){ // abstract method
        System.out.println("Skill = "+skill);
    }
    public void moving(String moving){ // abstract method

    }
    public void weapon(String weapon){ // abstract method

    }
    public void jumping(String jump){ // abstract method

    }
    public void setNation(String nation){ // abstract method
        
    }
}