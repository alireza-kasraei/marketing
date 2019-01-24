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

    
   SELECT
    sum(r.real_value)
FROM
    targets_members   tm
    INNER JOIN targets           t ON tm.target_id = t.id
    INNER JOIN teams_members     tmm ON tm.team_member_id = tmm.id
    INNER JOIN personnels        p ON tmm.personnel_id = p.id
    INNER JOIN services          s ON t.service_id = s.id
    INNER JOIN requirements      r on r.target_member_id=tm.id
    INNER JOIN customers c on r.customer_id=c.id
    INNER JOIN requirement_statuses rs on rs.requirement_id=r.id
    INNER JOIN requirement_status_types rst on rs.requirement_status_type_id=rst.id
    INNER JOIN assigned_requirements ar on ar.customer_requirement_id=r.id
    INNER JOIN assigned_requirements_statuses ars on ars.assigned_requirement_id=ar.id
    INNER JOIN assigned_status_types ast on ast.id=ars.assigned_status_type_id
    
    
    
    where rst.type_code='RS1'
    and ast.type_code='AST1'
    and t.register_date<=CURRENT_DATE

    
    
  