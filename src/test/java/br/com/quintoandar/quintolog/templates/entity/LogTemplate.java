package br.com.quintoandar.quintolog.templates.entity;

import br.com.quintoandar.quintolog.entity.LogError;
import br.com.quintoandar.quintolog.entity.enums.Environment;
import br.com.quintoandar.quintolog.entity.enums.LevelLog;
import br.com.quintoandar.quintolog.entity.enums.Status;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class LogTemplate implements TemplateLoader {
	
	public static final String VALIDO = "valido";

	@Override
	public void load() {
		Fixture.of(LogError.class).addTemplate(VALIDO, new Rule() {
			{
				add("id", 10L);
				add("numberEvents", 10L);
				add("levelLog", LevelLog.DEBUG);
				add("status", Status.ACTIVE);
				add("environment", Environment.DEV);
				add("description", "Descricao");
				add("details", "Detalhes");
				add("userId", 20L);
			}
		});
	}
}
