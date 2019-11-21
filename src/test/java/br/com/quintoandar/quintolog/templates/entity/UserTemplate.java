package br.com.quintoandar.quintolog.templates.entity;

import br.com.quintoandar.quintolog.entity.LogUser;
import br.com.quintoandar.quintolog.entity.Profile;
import br.com.quintoandar.quintolog.entity.enums.SecurityQuestion;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UserTemplate implements TemplateLoader {
	
	public static final String VALIDO = "valido";
	public static final String VALIDO_PROFILE = "profile valido";

	@Override
	public void load() {
		Fixture.of(LogUser.class).addTemplate(VALIDO, new Rule() {
			{
				add("id", 10L);
				add("name", "Nome Exemplo");
				add("email", "email@email.com");
				add("password", "password");
				add("securityQuestion", SecurityQuestion.ANIMAL);
				add("securityAnswer", "hipo");
				add("profiles", has(2).of(Profile.class, VALIDO_PROFILE));
			}
		});

		Fixture.of(Profile.class).addTemplate(VALIDO_PROFILE, new Rule() {
			{
				add("id", 123L);
				add("name", "admin");
			}
		});
	}
}
