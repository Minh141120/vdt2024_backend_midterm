{{/*
Return the fully qualified app name.
*/}}
{{- define "api.fullname" -}}
{{- printf "%s-%s" .Release.Name .Chart.Name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Return the name of the chart.
*/}}
{{- define "api.name" -}}
{{- printf "%s" .Chart.Name -}}
{{- end -}}

{{/*
Return the chart name and version.
*/}}
{{- define "api.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version -}}
{{- end -}}
