package org.eclipse.xtext.xtext.ui.wizard.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor.IFileCreator;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.ui.wizard.project.DefaultProjectFactoryContributor;
import org.eclipse.xtext.xtext.ui.wizard.project.WizardContribution;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;

@SuppressWarnings("all")
public class DslProjectContributor extends DefaultProjectFactoryContributor {
  private XtextProjectInfo projectInfo;
  
  public DslProjectContributor(final XtextProjectInfo projectInfo) {
    this.projectInfo = projectInfo;
  }
  
  public void contributeFiles(final IProject project, final IFileCreator creator) {
    CharSequence _workflow = this.workflow();
    String _basePackagePath = this.projectInfo.getBasePackagePath();
    String _plus = (_basePackagePath + "/Generate");
    String _languageNameAbbreviation = this.projectInfo.getLanguageNameAbbreviation();
    String _plus_1 = (_plus + _languageNameAbbreviation);
    String _plus_2 = (_plus_1 + ".mwe2");
    creator.writeToFile(_workflow, _plus_2);
    CharSequence _grammar = this.grammar();
    String _grammarFilePath = DslProjectContributor.grammarFilePath(this.projectInfo);
    creator.writeToFile(_grammar, _grammarFilePath);
    CharSequence _launchConfig = this.launchConfig();
    String _projectName = this.projectInfo.getProjectName();
    String _plus_3 = (".launch/Generate Language Infrastructure (" + _projectName);
    String _plus_4 = (_plus_3 + ").launch");
    creator.writeToFile(_launchConfig, _plus_4);
  }
  
  private CharSequence workflow() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module ");
    String _basePackagePath = this.projectInfo.getBasePackagePath();
    String _plus = (_basePackagePath + "/Generate");
    String _languageNameAbbreviation = this.projectInfo.getLanguageNameAbbreviation();
    String _plus_1 = (_plus + _languageNameAbbreviation);
    String _replaceAll = _plus_1.replaceAll("/", ".");
    _builder.append(_replaceAll, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.mwe.utils.*");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.generator.*");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.ui.generator.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("var grammarURI = \"classpath:/");
    String _basePackagePath_1 = this.projectInfo.getBasePackagePath();
    _builder.append(_basePackagePath_1, "");
    _builder.append("/");
    String _languageNameAbbreviation_1 = this.projectInfo.getLanguageNameAbbreviation();
    _builder.append(_languageNameAbbreviation_1, "");
    _builder.append(".xtext\"");
    _builder.newLineIfNotEmpty();
    _builder.append("var file.extensions = \"");
    String _fileExtension = this.projectInfo.getFileExtension();
    _builder.append(_fileExtension, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("var projectName = \"");
    String _projectName = this.projectInfo.getProjectName();
    _builder.append(_projectName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("var runtimeProject = \"../${projectName}\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Workflow {");
    _builder.newLine();
    _builder.append("    ");
    WizardContribution _wizardContribution = this.projectInfo.getWizardContribution();
    String _mweSnippet = _wizardContribution.getMweSnippet();
    _builder.append(_mweSnippet, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence grammar() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar ");
    String _languageName = this.projectInfo.getLanguageName();
    _builder.append(_languageName, "");
    _builder.append(" with org.eclipse.xtext.common.Terminals");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("generate ");
    String _languageNameAbbreviation = this.projectInfo.getLanguageNameAbbreviation();
    String _firstLower = StringExtensions.toFirstLower(_languageNameAbbreviation);
    _builder.append(_firstLower, "");
    _builder.append(" \"");
    String _nsURI = this.projectInfo.getNsURI();
    _builder.append(_nsURI, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("Model:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("greetings+=Greeting*;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("Greeting:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'Hello\' name=ID \'!\';");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence launchConfig() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<launchConfiguration type=\"org.eclipse.pde.ui.RuntimeWorkbench\">");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"append.args\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"askclear\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"automaticAdd\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"automaticValidate\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"bad_container_name\" value=\"/");
    String _projectName = this.projectInfo.getProjectName();
    _builder.append(_projectName, "");
    _builder.append("/.launch/\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("<stringAttribute key=\"bootstrap\" value=\"\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"checked\" value=\"[NONE]\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"clearConfig\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"clearws\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"clearwslog\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"configLocation\" value=\"${workspace_loc}/.metadata/.plugins/org.eclipse.pde.core/Launch Runtime Eclipse\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"default\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"includeOptional\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"location\" value=\"${workspace_loc}/../runtime-New_configuration\"/>");
    _builder.newLine();
    _builder.append("<listAttribute key=\"org.eclipse.debug.ui.favoriteGroups\">");
    _builder.newLine();
    _builder.append("<listEntry value=\"org.eclipse.debug.ui.launchGroup.debug\"/>");
    _builder.newLine();
    _builder.append("<listEntry value=\"org.eclipse.debug.ui.launchGroup.run\"/>");
    _builder.newLine();
    _builder.append("</listAttribute>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.JRE_CONTAINER\" value=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.PROGRAM_ARGUMENTS\" value=\"-os ${target.os} -ws ${target.ws} -arch ${target.arch} -nl ${target.nl}\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER\" value=\"org.eclipse.pde.ui.workbenchClasspathProvider\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.VM_ARGUMENTS\" value=\"-Xms40m -Xmx512m -XX:MaxPermSize=256m\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"pde.version\" value=\"3.3\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"product\" value=\"org.eclipse.platform.ide\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"show_selected_only\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"templateConfig\" value=\"${target_home}/configuration/config.ini\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"tracing\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"useDefaultConfig\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"useDefaultConfigArea\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"useProduct\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"usefeatures\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("</launchConfiguration>");
    _builder.newLine();
    return _builder;
  }
  
  public static String grammarFilePath(final XtextProjectInfo prjInfo) {
    String _basePackagePath = prjInfo.getBasePackagePath();
    String _plus = (_basePackagePath + "/");
    String _languageNameAbbreviation = prjInfo.getLanguageNameAbbreviation();
    String _plus_1 = (_plus + _languageNameAbbreviation);
    String _plus_2 = (_plus_1 + ".xtext");
    return _plus_2;
  }
}