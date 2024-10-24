class Thor extends SuperHero implements SkillHero{

    public void skill(String skill){
        System.out.println("Skill = "+skill);
    }
    public void moving(String moving){
        System.out.println("moving = "+moving);
    }
    public void weapon(String weapon){
        System.out.println("Weapon = "+weapon);
    }
    public void jumping(String jump){
        System.out.println("jumping = "+jump);
    }
}