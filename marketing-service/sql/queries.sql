SELECT
    p.personnel_name,
    p.user_name,
    t.target_name,
    t.id,
    t.target_value,
    t.days_count,
    tm.target_member_name,
    tm.target_member_value
FROM
    targets_members   tm
    INNER JOIN targets           t ON tm.target_id = t.id
    INNER JOIN teams_members     tmm ON tm.team_member_id = tmm.id
    INNER JOIN personnels        p ON tmm.personnel_id = p.id
    INNER JOIN services          s ON t.service_id = s.id;

    
    

    
    
  