package br.com.quintoandar.quintolog.templates.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import br.com.quintoandar.quintolog.entity.Log;
import br.com.quintoandar.quintolog.entity.enums.Level;
import br.com.quintoandar.quintolog.entity.enums.Status;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class LogTemplate implements TemplateLoader {
	
	public static final String VALIDO = "valido";

	@Override
	public void load() {
		Fixture.of(Log.class).addTemplate(VALIDO, new Rule() {
			{
				add("id", 10L);
				add("numberEvents", 10L);
				add("level", Level.DEBUG);
				add("status", Status.ACTIVE);
				add("environment", 10L);
				add("description", "Descricao");
				add("details", "Detalhes");
				add("createdAt", Timestamp.valueOf(LocalDateTime.now().minusDays(10)));
				add("userId", 20L);
			}
		});
	}
}
