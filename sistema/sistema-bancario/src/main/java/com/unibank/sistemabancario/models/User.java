package com.unibank.sistemabancario.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.DiscriminatorType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.unibank.sistemabancario.models.enums.TipoUser;

import lombok.Data;

@Entity
@Table(name = User.TABLE_NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Data
public class User {
    public interface CreateUser{}
    public interface UpdateUser{}

    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;


    @Column(name = "nome", length =  100, nullable = false)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    private String nome;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Email
    private String email;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "password", length = 100, nullable = false)
    @NotNull(groups = {CreateUser.class, UpdateUser.class} )
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class} )
    @Size(groups = {CreateUser.class, UpdateUser.class} , min = 8, max = 60)
    //NotBlank é o mesmo que colocar o NotNull + NotEmpty
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private TipoUser tipoUser;

}
