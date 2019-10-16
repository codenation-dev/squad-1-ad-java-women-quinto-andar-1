package br.com.quintoandar.quintolog.templates.entity;

import br.com.quintoandar.quintolog.entity.User;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UserTemplate implements TemplateLoader {
	
	public static final String VALIDO = "valido";

	@Override
	public void load() {
		Fixture.of(User.class).addTemplate(VALIDO, new Rule() {
			{
				add("id", 10L);
				add("name", "Nome Exemplo");
				add("email", "email@email.com");
				add("password", "password");
				add("avatar", "http://image.com");
			}
		});
	}
}
